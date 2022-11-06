package dev.ispiroglu.jobadvertysystem.dto.request.advert;

public class AddApplicantRequest {

  private Long userId;

  public AddApplicantRequest(Long userId) {
    this.userId = userId;
  }


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "AddApplicantRequest{" +
        "userId=" + userId +
        '}';
  }
}