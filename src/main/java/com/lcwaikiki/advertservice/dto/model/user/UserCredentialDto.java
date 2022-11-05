package com.lcwaikiki.advertservice.dto.model.user;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class UserCredentialDto {

  @NotBlank(message = "Id cannot be blank")
  private Long id;

  @NotNull(message = "isEmployer cannot be null")
  private boolean isEmployer;
  @NotNull(message = "email cannot be null")
  @NotEmpty(message = "email cannot be Empty")
  private String email;
  @NotNull(message = "Password cannot be Null")
  @NotEmpty(message = "Password cannot be Empty")
  private String password;

  private LocalDateTime creationDate;

  public UserCredentialDto() {
  }

  public UserCredentialDto(Long id, boolean isEmployer, String email, String password,
      LocalDateTime creationDate) {
    this.id = id;
    this.isEmployer = isEmployer;
    this.email = email;
    this.password = password;
    this.creationDate = creationDate;
  }

  public boolean isEmployer() {
    return isEmployer;
  }

  public void setEmployer(boolean employer) {
    isEmployer = employer;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public Long getId() {
    return id;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }
}
