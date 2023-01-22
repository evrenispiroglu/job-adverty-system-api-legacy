package dev.ispiroglu.jobadvertysystem.dto.response.advert;

import dev.ispiroglu.jobadvertysystem.dto.model.advert.AdvertCardInfoDto;
import java.util.List;

public class AdvertCardListResponse {

  private List<AdvertCardInfoDto> advertCardInfoDtoList;

  public AdvertCardListResponse(List<AdvertCardInfoDto> advertCardInfoDtoList) {
    this.advertCardInfoDtoList = advertCardInfoDtoList;
  }

  public List<AdvertCardInfoDto> getAdvertCardInfoDtoList() {
    return advertCardInfoDtoList;
  }
}
