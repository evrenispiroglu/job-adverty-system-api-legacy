package dev.ispiroglu.jobadvertysystem.controller;


import dev.ispiroglu.jobadvertysystem.dto.model.user.UserCredentialDto;
import dev.ispiroglu.jobadvertysystem.dto.request.user.CreateUserRequest;
import dev.ispiroglu.jobadvertysystem.dto.request.user.UpdateUserCvRequest;
import dev.ispiroglu.jobadvertysystem.dto.request.user.UpdateUserPhotoRequest;
import dev.ispiroglu.jobadvertysystem.dto.request.user.UpdateUserRequest;
import dev.ispiroglu.jobadvertysystem.dto.response.user.UserApplicationTableAdvertInfo;
import dev.ispiroglu.jobadvertysystem.dto.response.user.UserDetailResponse;
import dev.ispiroglu.jobadvertysystem.dto.response.user.UserLoginResponse;
import dev.ispiroglu.jobadvertysystem.exception.UserNotFoundException;
import dev.ispiroglu.jobadvertysystem.model.User;
import dev.ispiroglu.jobadvertysystem.service.OperationHandlerService;
import dev.ispiroglu.jobadvertysystem.service.UserService;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/users")
@Slf4j
public class UserController {

  private final UserService userService;
  private final OperationHandlerService operationHandlerService;


  public UserController(UserService userService, OperationHandlerService operationHandlerService) {
    this.userService = userService;
    this.operationHandlerService = operationHandlerService;
  }

  @GetMapping
  public List<User> findAll() {
    return userService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDetailResponse> getUserDetail(@PathVariable long id)
      throws UserNotFoundException {
    return ResponseEntity.ok().body(userService.getUserDetail(id));
  }

  @GetMapping("/login/{email}")
  public ResponseEntity<UserLoginResponse> getUserDetail(@PathVariable String email)
      throws UserNotFoundException {
    return ResponseEntity.ok().body(operationHandlerService.getUserDetail(email));
  }

  @GetMapping("/{id}/fullInfo")
  public ResponseEntity<User> findById(@PathVariable long id) throws UserNotFoundException {
    return ResponseEntity.ok().body(userService.findById(id));
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/registration")
  public ResponseEntity<UserCredentialDto> createUser(
      @RequestBody CreateUserRequest createUserRequest) {
    return ResponseEntity.ok(userService.createUser(createUserRequest));
  }

  @ResponseStatus(HttpStatus.NO_CONTENT) // Is this approach true?
  @PatchMapping(value = "/{id}")
  public void update(
      @RequestBody UpdateUserRequest updateUserRequest, @PathVariable Long id)
      throws UserNotFoundException {
    userService.updateUser(id, updateUserRequest);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable long id) throws UserNotFoundException {
    userService.deleteUser(id);
  }

  @PatchMapping("/{id}/photo")
  public void upload(UpdateUserPhotoRequest request, @PathVariable Long id)
      throws UserNotFoundException, IOException {
    userService.updateUserProfilePicture(request.getFile(), id);
  }

  @GetMapping("/{id}/photo")
  public ResponseEntity<Blob> getUserProfilePhoto(@PathVariable Long id)
      throws UserNotFoundException, SQLException {
    return ResponseEntity.ok(userService.getUserProfilePhoto(id));
  }

  @PatchMapping("/{id}/cv")
  public void upload(UpdateUserCvRequest request, @PathVariable Long id)
      throws UserNotFoundException, IOException {
    userService.updateUserCv(request.getFile(), id);
  }

  @GetMapping("/{id}/cv")
  public ResponseEntity<Blob> getUserCv(@PathVariable Long id)
      throws UserNotFoundException, SQLException {
    return ResponseEntity.ok().body(userService.getUserCv(id));
  }

  @GetMapping("/{id}/applications")
  public ResponseEntity<List<UserApplicationTableAdvertInfo>> getUserApplications(
      @PathVariable Long id)
      throws UserNotFoundException {
    return ResponseEntity.ok(userService.getAppliedAdverts(id));
  }

//  @GetMapping("/{id}/ownedAdverts")
//  public ResponseEntity<List<Long>> getOwnedAdvertIDs(@PathVariable Long id)
//      throws UserNotFoundException {
//    return ResponseEntity.ok(operationHandlerService.getOwnedAdvertIDs(id));
//  }
}
