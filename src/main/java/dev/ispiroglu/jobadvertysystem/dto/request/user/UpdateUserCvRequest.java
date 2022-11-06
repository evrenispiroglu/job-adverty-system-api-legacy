package dev.ispiroglu.jobadvertysystem.dto.request.user;

import org.springframework.web.multipart.MultipartFile;

public class UpdateUserCvRequest {

  private MultipartFile file;

  public UpdateUserCvRequest(MultipartFile file) {
    this.file = file;
  }

  public MultipartFile getFile() {
    return file;
  }

  public void setFile(MultipartFile file) {
    this.file = file;
  }
}
