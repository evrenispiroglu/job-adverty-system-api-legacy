package dev.ispiroglu.jobadvertysystem.exception;

public class UserAlreadyAppliedException extends Exception {

  public UserAlreadyAppliedException() {
    super("User already applied!");
  }
}
