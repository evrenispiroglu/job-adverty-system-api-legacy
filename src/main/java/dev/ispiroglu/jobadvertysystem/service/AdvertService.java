package dev.ispiroglu.jobadvertysystem.service;

import dev.ispiroglu.jobadvertysystem.dto.converter.AdvertDtoConverter;
import dev.ispiroglu.jobadvertysystem.dto.converter.UserDtoConverter;
import dev.ispiroglu.jobadvertysystem.dto.model.advert.AdvertCardInfoDto;
import dev.ispiroglu.jobadvertysystem.dto.model.advert.DashboardAdvertTableInfoDto;
import dev.ispiroglu.jobadvertysystem.dto.request.advert.CreateAdvertRequest;
import dev.ispiroglu.jobadvertysystem.dto.request.advert.GetFilteredAdvertsRequest;
import dev.ispiroglu.jobadvertysystem.dto.request.advert.UpdateAdvertRequest;
import dev.ispiroglu.jobadvertysystem.dto.response.advert.AdvertInfoResponse;
import dev.ispiroglu.jobadvertysystem.dto.response.user.AdvertAppliedUserInfoResponse;
import dev.ispiroglu.jobadvertysystem.exception.AdvertNotFoundException;
import dev.ispiroglu.jobadvertysystem.exception.UserNotFoundException;
import dev.ispiroglu.jobadvertysystem.model.Advert;
import dev.ispiroglu.jobadvertysystem.model.AdvertOwner;
import dev.ispiroglu.jobadvertysystem.model.ApplicationDetail;
import dev.ispiroglu.jobadvertysystem.repository.AdvertOwnerRepository;
import dev.ispiroglu.jobadvertysystem.repository.AdvertRepository;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@Slf4j
public class AdvertService {

  private final AdvertRepository advertRepository;
  private final AdvertDtoConverter advertDtoConverter;
  private final UserDtoConverter userDtoConverter;
  private final AdvertOwnerRepository advertOwnerRepository;
  private final UserService userService;
  private final EmailServiceImpl emailService;

  public AdvertService(AdvertRepository advertRepository,
                       AdvertDtoConverter advertDtoConverter, UserDtoConverter userDtoConverter,
                       AdvertOwnerRepository advertOwnerRepository, UserService userService,
                       EmailServiceImpl emailService) {
    this.advertRepository = advertRepository;
    this.advertDtoConverter = advertDtoConverter;
    this.userDtoConverter = userDtoConverter;
    this.advertOwnerRepository = advertOwnerRepository;
    this.userService = userService;
    this.emailService = emailService;
  }

  public Advert createAdvert(CreateAdvertRequest createAdvertRequest) {
    Advert advert = advertDtoConverter.convertToAdvert(createAdvertRequest);
    log.info("Saving the advert: Id:{} {}|{}", advert.getId(), advert.getCompanyName(),
        advert.getName());
    return advertRepository.save(advert);
  }

  public void updateAdvert(UpdateAdvertRequest updateAdvertRequest, Long id)
      throws AdvertNotFoundException, ParseException {
    Advert advert = advertRepository.findById(id).orElseThrow(AdvertNotFoundException::new);
    Advert advertToSave = advertDtoConverter.convertToAdvert(updateAdvertRequest);
    advertToSave.setCreationDate(advert.getCreationDate());
    advertToSave.setId(advert.getId());
    advertToSave.setUpdate(advert.getUpdate());
    advertToSave.setActive(advert.isActive());
    advertToSave.setPhoto(advert.getPhoto());

    log.info("Updating the advert: Id:{} {}|{}", advert.getId(), advert.getCompanyName(),
        advert.getName());
    advertRepository.save(advertToSave);
  }

  public void deleteAdvert(long id) throws AdvertNotFoundException {
    Advert advert = advertRepository.findById(id).orElseThrow(AdvertNotFoundException::new);
    advert.setActive(false);
    log.info("Soft delete on advert: Id:{} {}|{}", advert.getId(), advert.getCompanyName(),
        advert.getName());
    advertRepository.save(advert);
  }

  public List<AdvertCardInfoDto> findFilteredAdverts(GetFilteredAdvertsRequest request, Long id)
      throws SQLException, UserNotFoundException {

    if (id == -1) {
      List<AdvertCardInfoDto> list = new LinkedList<>();
      advertRepository.findAdvertsByFullFilter(request.getProvince(), request.getPosition(),
          request.getDepartment(), request.getSearchText()).forEach(advert -> {
        try {
          list.add(advertDtoConverter.convertToAdvertCardInfo(advert));
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
      });
      return list;
    }
    List<AdvertCardInfoDto> returningList = new LinkedList<>();
    List<AdvertOwner> list = advertOwnerRepository.findAdvertOwnersByUserAndAdvert_Active(
        userService.findById(id), true);
    for (AdvertOwner advertOwner : list) {
      Advert advert = advertOwner.getAdvert();
      if (advert.getProvince().contains(request.getProvince()) &&
          advert.getPosition().contains(request.getPosition()) &&
          advert.getDepartment().contains(request.getDepartment()) && (advert.getName().contains(
          request.getSearchText()) || advert.getSummary().contains(request.getSearchText()))) {
        returningList.add(advertDtoConverter.convertToAdvertCardInfo(advert));
      }
    }
    return returningList;
  }

  public void addUserToAdvert(Advert advert, ApplicationDetail application) {
    advert.addApplication(application);
    if (advert.getApplications().size() == advert.getCapacity()) {
      closeAdvert(advert);
    }
    advertRepository.save(advert);
  }

  public List<Advert> findAll() {
    return advertRepository.findAll();
  }

  public Advert findById(long id) throws AdvertNotFoundException {
    return advertRepository.findById(id).orElseThrow(AdvertNotFoundException::new);
  }

  public void updateAdvertPhoto(MultipartFile file, Long id)
      throws AdvertNotFoundException, IOException, SQLException {
    Advert advert = findById(id);
    advert.setPhoto((file.getBytes()));
    log.info("Photo update on advert: Id:{} {}|{}", advert.getId(), advert.getCompanyName(),
        advert.getName());
    advertRepository.save(advert);
  }

  public Blob getAdvertPhoto(Long id) throws AdvertNotFoundException, SQLException {
    return new SerialBlob(findById(id).getPhoto());
  }

  public Long getAdvertCount() {
    return advertRepository.count();
  }

  public LinkedList<DashboardAdvertTableInfoDto> getEndingAdverts() {
    long DAY_IN_MS = 1000 * 60 * 60 * 24;
    java.util.Date utilDate = new java.util.Date(System.currentTimeMillis() + (7 * DAY_IN_MS));
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    LinkedList<DashboardAdvertTableInfoDto> list = new LinkedList<>();
    advertRepository.findEndingAdverts(sqlDate)
        .forEach(advert -> list.add(advertDtoConverter.convertToDashboardAdvertInfo(advert)));

    return list;
  }

  public List<DashboardAdvertTableInfoDto> getStartingAdverts() {
    long DAY_IN_MS = 1000 * 60 * 60 * 24;
    java.util.Date utilDate = new java.util.Date(System.currentTimeMillis() - (7 * DAY_IN_MS));
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    List<DashboardAdvertTableInfoDto> list = new ArrayList<>();
    advertRepository.findStartingAdverts(sqlDate)
        .forEach(advert -> list.add(advertDtoConverter.convertToDashboardAdvertInfo(advert)));
    return list;
  }

  public Page<AdvertCardInfoDto> getAdvertCards(int page, Long creatorID)
      throws UserNotFoundException {
    PageRequest pr = PageRequest.of(page, 12);

    Page<AdvertOwner> test;

    if (creatorID != -1) {
      test = advertOwnerRepository.findAdvertOwnersByUserAndAdvert_Active(
          userService.findById(creatorID), pr, true);
    } else {
      test = advertOwnerRepository.findAdvertOwnersByAdvert_Active(pr, true);
    }
    return test.map(advertOwner -> {
      try {
        return advertDtoConverter.convertToAdvertCardInfo(advertOwner.getAdvert());
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    });
  }

  public AdvertInfoResponse getAdvertInfo(Long id) throws AdvertNotFoundException {
    return advertDtoConverter.convertToAdminInfoResponse(findById(id));
  }

  public List<AdvertAppliedUserInfoResponse> getApplicants(Long id) throws AdvertNotFoundException {
    List<AdvertAppliedUserInfoResponse> list = new ArrayList<>();
    findById(id).getApplications().stream()
        .filter(applicationDetail -> !applicationDetail.isDecided())
        .forEach(applicationDetail -> list.add(
            userDtoConverter.convertToAdvertAppliedUserInfoResponse(applicationDetail.getUser())));
    return list;
  }

  public Boolean canClose(Long id) throws AdvertNotFoundException {
    for (ApplicationDetail application : findById(id).getApplications()) {
      if (!application.isDecided()) {
        return false;
      }
    }

    return true;
  }

  public void closeAdvert(Advert advert) {
    emailService.sendSimpleMessage(advert.getAdvertOwner().getUser().getEmail(),
        "Advert has reached the maximum number of applications.",
        advert.getName() + " cannot get applicants anymore. Please handle the applications.");
  }

  public boolean isAdvertActive(Long id) throws AdvertNotFoundException {
    return findById(id).isActive();
  }
}
