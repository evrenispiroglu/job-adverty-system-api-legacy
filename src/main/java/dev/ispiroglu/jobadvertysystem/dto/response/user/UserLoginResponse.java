package dev.ispiroglu.jobadvertysystem.dto.response.user;

import java.util.LinkedList;

public class UserLoginResponse {

  private Long id;
  private boolean isEmployer;

  private LinkedList<Long> ownedAdvertIDs;

  public UserLoginResponse(Long id, boolean isEmployer, LinkedList<Long> ownedAdvertIDs) {
    this.id = id;
    this.isEmployer = isEmployer;
    this.ownedAdvertIDs = ownedAdvertIDs;
  }

  public UserLoginResponse() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isEmployer() {
    return isEmployer;
  }

  public void setEmployer(boolean employer) {
    isEmployer = employer;
  }

  public LinkedList<Long> getOwnedAdvertIDs() {
    return ownedAdvertIDs;
  }

  public void setOwnedAdvertIDs(LinkedList<Long> ownedAdvertIDs) {
    this.ownedAdvertIDs = ownedAdvertIDs;
  }
}
