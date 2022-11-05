package com.lcwaikiki.advertservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class UserNotValidForApplicationException extends Exception {

  public UserNotValidForApplicationException() {
    super("User is not valid for application. Should implement all the areas in detail section");
  }
}
