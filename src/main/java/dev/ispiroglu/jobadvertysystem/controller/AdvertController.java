package dev.ispiroglu.jobadvertysystem.controller;

import dev.ispiroglu.jobadvertysystem.dto.model.advert.AdvertCardInfoDto;
import dev.ispiroglu.jobadvertysystem.dto.model.advert.AdvertDetailsDto;
import dev.ispiroglu.jobadvertysystem.dto.model.advert.DashboardAdvertTableInfoDto;
import dev.ispiroglu.jobadvertysystem.dto.request.advert.CreateAdvertRequest;
import dev.ispiroglu.jobadvertysystem.dto.request.advert.GetFilteredAdvertsRequest;
import dev.ispiroglu.jobadvertysystem.dto.request.advert.UpdateAdvertPhotoRequest;
import dev.ispiroglu.jobadvertysystem.dto.request.advert.UpdateAdvertRequest;
import dev.ispiroglu.jobadvertysystem.dto.request.applicationdetail.UpdateApplicationStatusRequest;
import dev.ispiroglu.jobadvertysystem.dto.response.advert.AdvertInfoResponse;
import dev.ispiroglu.jobadvertysystem.dto.response.user.AdvertAppliedUserInfoResponse;
import dev.ispiroglu.jobadvertysystem.exception.AdvertIsFullException;
import dev.ispiroglu.jobadvertysystem.exception.AdvertNotFoundException;
import dev.ispiroglu.jobadvertysystem.exception.UserAlreadyAppliedException;
import dev.ispiroglu.jobadvertysystem.exception.UserNotFoundException;
import dev.ispiroglu.jobadvertysystem.exception.UserNotValidForApplicationException;
import dev.ispiroglu.jobadvertysystem.model.Advert;
import dev.ispiroglu.jobadvertysystem.service.AdvertService;
import dev.ispiroglu.jobadvertysystem.service.OperationHandlerService;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/adverts")
@Slf4j
public class AdvertController {

  private final AdvertService advertService;
  private final OperationHandlerService operationHandlerService;

  public AdvertController(AdvertService advertService,
                          OperationHandlerService operationHandlerService) {
    this.advertService = advertService;
    this.operationHandlerService = operationHandlerService;
  }

  @GetMapping("/allAdverts")
  public List<Advert> findAll() {
    return advertService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Advert> findById(@PathVariable long id) throws AdvertNotFoundException {
    return ResponseEntity.ok(advertService.findById(id));
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public ResponseEntity<AdvertDetailsDto> create(
      @RequestBody CreateAdvertRequest createAdvertRequest, @RequestParam Long userID)
      throws UserNotFoundException {
    return ResponseEntity.ok(operationHandlerService.createAdvert(createAdvertRequest, userID));
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PatchMapping("/{id}/advertInfo")
  public void update(@RequestBody UpdateAdvertRequest updateAdvertRequest,
                     @PathVariable long id)
      throws AdvertNotFoundException, ParseException {
    advertService.updateAdvert(updateAdvertRequest, id);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable long id) throws AdvertNotFoundException {
    advertService.deleteAdvert(id);
  }

  @GetMapping
  public ResponseEntity<Page<AdvertCardInfoDto>> getAdvertCards(@RequestParam int page,
                                                                @RequestParam Long userID)
      throws UserNotFoundException {
    return ResponseEntity.ok(advertService.getAdvertCards(page, userID));
  }

  @PatchMapping("/filter") // Patch ??
  public ResponseEntity<List<AdvertCardInfoDto>> findFilteredAdverts(
      @RequestBody GetFilteredAdvertsRequest request, @RequestParam Long userID)
      throws SQLException, UserNotFoundException {
    return ResponseEntity.ok(advertService.findFilteredAdverts(request, userID));
  }


  @PostMapping("/{id}/applications")
  public void addUserToAdvert(@RequestBody Long userID, @PathVariable Long id)
      throws UserNotFoundException, AdvertNotFoundException, UserNotValidForApplicationException,
      AdvertIsFullException, UserAlreadyAppliedException {
    operationHandlerService.addApplicantToAdvert(id, userID);
  }

  @GetMapping("/{id}/applications")
  public ResponseEntity<List<AdvertAppliedUserInfoResponse>> getApplicants(@PathVariable Long id)
      throws AdvertNotFoundException {
    return ResponseEntity.ok(advertService.getApplicants(id));
  }

  @GetMapping("/{id}/applications/closable")
  public ResponseEntity<Boolean> getClosable(@PathVariable Long id)
      throws AdvertNotFoundException {
    return ResponseEntity.ok(advertService.canClose(id));
  }

  @GetMapping("/{id}/applications/active")
  public ResponseEntity<Boolean> isActive(@PathVariable Long id)
      throws AdvertNotFoundException {
    return ResponseEntity.ok(advertService.isAdvertActive(id));
  }

  @PatchMapping("/{id}/applications")
  public void updateApplicationStatus(@RequestBody UpdateApplicationStatusRequest request,
                                      @PathVariable Long id)
      throws UserNotFoundException, AdvertNotFoundException {
    operationHandlerService.updateApplicationStatus(id, request.getUserId(),
        request.getNewStatus());
  }

  @PatchMapping("/{id}/photo")
  public void updateAdvertPhoto(UpdateAdvertPhotoRequest request,
                                @PathVariable Long id)
      throws IOException, AdvertNotFoundException, SQLException {
    advertService.updateAdvertPhoto(request.getFile(), id);
  }

  @GetMapping("/{id}/photo")
  public ResponseEntity<Blob> getAdvertPhoto(@PathVariable Long id)
      throws AdvertNotFoundException, SQLException {
    return ResponseEntity.ok()
        .body(advertService.getAdvertPhoto(id));
  }

  @GetMapping("/count")
  public ResponseEntity<Long> getAdvertCount() {
    return ResponseEntity.ok(advertService.getAdvertCount());
  }

  @GetMapping("/soonEndingAdverts")
  public ResponseEntity<List<DashboardAdvertTableInfoDto>> getSoonEndings() {
    return ResponseEntity.ok(advertService.getEndingAdverts());
  }

  @GetMapping("/{id}/advertInfo")
  public ResponseEntity<AdvertInfoResponse> getAdvertInfo(@PathVariable Long id)
      throws AdvertNotFoundException {
    return ResponseEntity.ok(advertService.getAdvertInfo(id));
  }

}
