package com.lcwaikiki.advertservice.dto.request.advert;

import org.springframework.web.multipart.MultipartFile;

public class UpdateAdvertPhotoRequest {

  private MultipartFile file;

  public UpdateAdvertPhotoRequest(MultipartFile file) {
    this.file = file;
  }

  public MultipartFile getFile() {
    return file;
  }

  public void setFile(MultipartFile file) {
    this.file = file;
  }


}
