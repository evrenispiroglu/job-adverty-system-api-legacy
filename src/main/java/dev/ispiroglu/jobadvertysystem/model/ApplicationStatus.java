package dev.ispiroglu.jobadvertysystem.model;

public enum ApplicationStatus {
  REJECT("Rejected"), ACCEPT("Accepted"), PENDING("Pending");

  private String status;

  ApplicationStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}
