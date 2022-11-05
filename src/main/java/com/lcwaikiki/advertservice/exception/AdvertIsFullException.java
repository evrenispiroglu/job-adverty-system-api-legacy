package com.lcwaikiki.advertservice.exception;

public class AdvertIsFullException extends Exception {

  public AdvertIsFullException() {
    super("There is no room for any other application.");
  }
}
