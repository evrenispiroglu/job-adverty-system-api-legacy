package dev.ispiroglu.jobadvertysystem.dto.response.user;

import dev.ispiroglu.jobadvertysystem.model.ApplicationStatus;

public class UserApplicationTableAdvertInfo {

  private String name;
  private String position;
  private String summary;
  private String location;
  private ApplicationStatus status;

  public UserApplicationTableAdvertInfo(String name, String position, String summary,
      String location,
      ApplicationStatus status) {
    this.name = name;
    this.position = position;
    this.summary = summary;
    this.location = location;
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public ApplicationStatus getStatus() {
    return status;
  }

  public void setStatus(ApplicationStatus status) {
    this.status = status;
  }
}
