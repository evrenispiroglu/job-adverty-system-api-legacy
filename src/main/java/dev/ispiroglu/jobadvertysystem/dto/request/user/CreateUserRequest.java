package dev.ispiroglu.jobadvertysystem.dto.request.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateUserRequest {

  @NotNull(message = "isEmployer cannot be null")
  private boolean isEmployer;
  @NotNull(message = "email cannot be null")
  @NotEmpty(message = "email cannot be Empty")
  private String email;
  @NotNull(message = "Password cannot be Null")
  @NotEmpty(message = "Password cannot be Empty")
  private String password;
  private String firstname;
  private String lastname;

  public CreateUserRequest(boolean isEmployer, String email, String password, String firstname,
                           String lastname) {
    this.isEmployer = isEmployer;
    this.email = email;
    this.password = password;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public boolean isEmployer() {
    return isEmployer;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  @Override
  public String toString() {
    return "CreateUserRequest{" +
        "isEmployer=" + isEmployer +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", firstname='" + firstname + '\'' +
        ", lastname='" + lastname + '\'' +
        '}';
  }
}
