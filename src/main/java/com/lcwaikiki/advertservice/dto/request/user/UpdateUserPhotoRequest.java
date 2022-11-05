package com.lcwaikiki.advertservice.dto.request.user;

import org.springframework.web.multipart.MultipartFile;

public class UpdateUserPhotoRequest {

  private MultipartFile file;

  public UpdateUserPhotoRequest(MultipartFile file) {
    this.file = file;
  }

  public MultipartFile getFile() {
    return file;
  }

  public void setFile(MultipartFile file) {
    this.file = file;
  }
}
