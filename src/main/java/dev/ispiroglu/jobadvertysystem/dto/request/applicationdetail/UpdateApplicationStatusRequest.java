package dev.ispiroglu.jobadvertysystem.dto.request.applicationdetail;

import dev.ispiroglu.jobadvertysystem.model.ApplicationStatus;

public class UpdateApplicationStatusRequest {

  //  private Long advertId;
  private Long userId;
  private ApplicationStatus newStatus;

  public UpdateApplicationStatusRequest(Long userId, ApplicationStatus newStatus) {
    this.userId = userId;
    this.newStatus = newStatus;
  }

  public UpdateApplicationStatusRequest() {
  }


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public ApplicationStatus getNewStatus() {
    return newStatus;
  }

  public void setNewStatus(ApplicationStatus newStatus) {
    this.newStatus = newStatus;
  }
}
