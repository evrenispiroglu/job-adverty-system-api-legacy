package dev.ispiroglu.jobadvertysystem.service;

import dev.ispiroglu.jobadvertysystem.dto.converter.AdvertDtoConverter;
import dev.ispiroglu.jobadvertysystem.dto.model.advert.AdvertDetailsDto;
import dev.ispiroglu.jobadvertysystem.dto.model.advert.DashboardAdvertTableInfoDto;
import dev.ispiroglu.jobadvertysystem.dto.request.advert.CreateAdvertRequest;
import dev.ispiroglu.jobadvertysystem.dto.response.advert.DashboardInfoResponse;
import dev.ispiroglu.jobadvertysystem.dto.response.user.UserLoginResponse;
import dev.ispiroglu.jobadvertysystem.exception.AdvertIsFullException;
import dev.ispiroglu.jobadvertysystem.exception.AdvertNotFoundException;
import dev.ispiroglu.jobadvertysystem.exception.UserAlreadyAppliedException;
import dev.ispiroglu.jobadvertysystem.exception.UserNotFoundException;
import dev.ispiroglu.jobadvertysystem.exception.UserNotValidForApplicationException;
import dev.ispiroglu.jobadvertysystem.model.Advert;
import dev.ispiroglu.jobadvertysystem.model.AdvertOwner;
import dev.ispiroglu.jobadvertysystem.model.ApplicationDetail;
import dev.ispiroglu.jobadvertysystem.model.ApplicationStatus;
import dev.ispiroglu.jobadvertysystem.model.User;
import dev.ispiroglu.jobadvertysystem.repository.AdvertOwnerRepository;
import dev.ispiroglu.jobadvertysystem.repository.ApplicationDetailRepository;
import dev.ispiroglu.jobadvertysystem.util.advert.AdvertValidationUtil;
import dev.ispiroglu.jobadvertysystem.util.user.UserValidationUtil;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OperationHandlerService {

  private final UserService userService;
  private final AdvertService advertService;
  private final AdvertDtoConverter advertDtoConverter;
  private final ApplicationDetailRepository applicationDetailRepository;
  private final AdvertOwnerRepository advertOwnerRepository;

  public OperationHandlerService(UserService userService, AdvertService advertService,
                                 AdvertDtoConverter advertDtoConverter,
                                 ApplicationDetailRepository applicationDetailRepository,
                                 AdvertOwnerRepository advertOwnerRepository) {
    this.userService = userService;
    this.advertService = advertService;
    this.advertDtoConverter = advertDtoConverter;
    this.applicationDetailRepository = applicationDetailRepository;
    this.advertOwnerRepository = advertOwnerRepository;
  }

  public void updateApplicationStatus(Long advertId, Long userId, ApplicationStatus newStatus)
      throws AdvertNotFoundException, UserNotFoundException {
    ApplicationDetail application = applicationDetailRepository.getApplicationDetailByAdvertAndUser(
        advertService.findById(advertId), userService.findById(userId)
    );

    application.setStatus(newStatus);
    application.setDecided(true);
    applicationDetailRepository.save(application);
  }

  public DashboardInfoResponse getDashboardInfoDto(Long id) throws UserNotFoundException {
    long DAY_IN_MS = 1000 * 60 * 60 * 24;
    long afterThreshold = new Date(System.currentTimeMillis() + (7 * DAY_IN_MS)).getTime();
    User user = userService.findById(id);
    long applicationCount = 0;
    List<Advert> ownedAdverts = new LinkedList<>();
    user.getOwnedAdverts()
        .forEach(advertOwner -> ownedAdverts.add(advertOwner.getAdvert()));

    AdvertDtoConverter converter = new AdvertDtoConverter();

    List<DashboardAdvertTableInfoDto> endingAdverts = new LinkedList<>();
    List<DashboardAdvertTableInfoDto> startingAdverts = new LinkedList<>();

    for (Advert ownedAdvert : ownedAdverts) {
      applicationCount += ownedAdvert.getApplications().size();
      if (ownedAdvert.getStartDate().getTime() > afterThreshold) {
        startingAdverts.add(converter.convertToDashboardAdvertInfo(ownedAdvert));
      }
      if (ownedAdvert.getEndDate().getTime() < afterThreshold) {
        endingAdverts.add(converter.convertToDashboardAdvertInfo(ownedAdvert));
      }
    }

    return new DashboardInfoResponse(
        (long) user.getOwnedAdverts().size(),
        applicationCount,
        userService.getUserCount(),
        endingAdverts, startingAdverts
    );
  }

  public void addApplicantToAdvert(Long advertId, Long userId)
      throws UserNotFoundException, AdvertNotFoundException, UserNotValidForApplicationException,
      AdvertIsFullException, UserAlreadyAppliedException {

    User user = userService.findById(userId);
    if (!UserValidationUtil.isValidForApplication(user)) {
      throw new UserNotValidForApplicationException();
    }

    Advert advert = advertService.findById(advertId);
    if (!AdvertValidationUtil.isAdvertCapacityFull(advert)) {
      throw new AdvertIsFullException();
    }

    if (applicationDetailRepository.getApplicationDetailByAdvertAndUser(advert, user) != null) {
      throw new UserAlreadyAppliedException();
    }

    ApplicationDetail application = new ApplicationDetail(
        advert, user
    );

    userService.addApplicationToUser(user, application);
    advertService.addUserToAdvert(advert, application);

    log.info("Created application for user Id:{} {} on advert Id:{}, {}|{}",
        user.getId(), user.getFirstname() + " " + user.getLastname(),
        advert.getId(), advert.getCompanyName(), advert.getName()
    );
    applicationDetailRepository.save(application);
  }

  public AdvertDetailsDto createAdvert(CreateAdvertRequest createAdvertRequest, Long creatorID)
      throws UserNotFoundException {
    Advert advert = advertService.createAdvert(createAdvertRequest);
    User user = userService.findById(creatorID);
    AdvertOwner advertOwner = new AdvertOwner(advert, user);
    userService.addAdvertOwnershipToUser(advertOwner, user);
    return advertDtoConverter.convertToAdvertDetailsDto(advert);
  }

  public List<Long> getOwnedAdvertIDs(Long userID) throws UserNotFoundException {
    List<Long> advertIDs = new LinkedList<>();
    advertOwnerRepository.findAdvertOwnersByUserAndAdvert_Active(userService.findById(userID), true)
        .forEach(advertOwner -> advertIDs.add(advertOwner.getAdvert().getId()));
    return advertIDs;
  }

  public UserLoginResponse getUserDetail(String email) {
    LinkedList<Long> idList = new LinkedList<>();
    User user = userService.findByEmail(email);
    user.getOwnedAdverts().forEach(ownedAdvert -> idList.add(ownedAdvert.getAdvert().getId()));
    return new UserLoginResponse(user.getId(), user.isEmployer(), idList);
  }
}
