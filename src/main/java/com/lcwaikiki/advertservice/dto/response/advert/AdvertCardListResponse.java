package com.lcwaikiki.advertservice.dto.response.advert;

import com.lcwaikiki.advertservice.dto.model.advert.AdvertCardInfoDto;
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
