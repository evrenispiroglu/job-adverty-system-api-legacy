package com.lcwaikiki.advertservice.util.advert;

import com.lcwaikiki.advertservice.model.Advert;

public class AdvertValidationUtil {

  public static boolean isAdvertCapacityFull(Advert advert) {
    System.out.println("Capacity ->  " + advert.getCapacity());
    System.out.println("size -> " + advert.getApplications().size());
    return advert.getCapacity() != advert.getApplications().size();
  }
}
