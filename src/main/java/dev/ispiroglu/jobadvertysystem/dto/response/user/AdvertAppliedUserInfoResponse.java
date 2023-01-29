package dev.ispiroglu.jobadvertysystem.dto.response.user;

public class AdvertAppliedUserInfoResponse {

  private Long id;

  private String firstname;
  private String lastname;
  private String email;
  private int experience;
  private String location;

  public AdvertAppliedUserInfoResponse(Long id, String firstname, String lastname, String email,
                                       int experience, String location) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.experience = experience;
    this.location = location;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getEmail() {
    return email;
  }

  public int getExperience() {
    return experience;
  }

  public String getLocation() {
    return location;
  }

  public Long getId() {
    return id;
  }
}
