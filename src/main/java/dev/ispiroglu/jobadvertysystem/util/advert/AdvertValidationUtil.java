package dev.ispiroglu.jobadvertysystem.util.advert;

import dev.ispiroglu.jobadvertysystem.model.Advert;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdvertValidationUtil {

  public static boolean isAdvertCapacityFull(Advert advert) {
    log.info("Is Advert Capacity Full Check");
    log.info("Capacity ->  " + advert.getName() + " | " + advert.getCompanyName());
    log.info("Capacity ->  " + advert.getCapacity());
    log.info("Size -> " + advert.getApplications().size());
    return advert.getCapacity() != advert.getApplications().size();
  }
}
