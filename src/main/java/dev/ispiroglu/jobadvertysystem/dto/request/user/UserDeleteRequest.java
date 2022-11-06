package dev.ispiroglu.jobadvertysystem.dto.request.user;

public class UserDeleteRequest {

  private Long id;

  public UserDeleteRequest(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
