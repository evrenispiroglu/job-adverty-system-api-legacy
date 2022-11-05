package com.lcwaikiki.advertservice.dto.model.advert;

import java.sql.Blob;

public class AdvertCardInfoDto {

  private Long id;
  private Blob image;
  private String advertName;
  private String position;
  private String summary;
  private String location;

  public AdvertCardInfoDto(Long id, Blob image, String advertName, String position,
      String summary,
      String location) {
    this.id = id;
    this.image = image;
    this.advertName = advertName;
    this.position = position;
    this.summary = summary;
    this.location = location;
  }

  public Blob getImage() {
    return image;
  }

  public String getAdvertName() {
    return advertName;
  }

  public Long getId() {
    return id;
  }

  public String getPosition() {
    return position;
  }

  public String getSummary() {
    return summary;
  }

  public String getLocation() {
    return location;
  }
}
