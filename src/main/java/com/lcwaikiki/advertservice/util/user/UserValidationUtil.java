package com.lcwaikiki.advertservice.util.user;

import com.lcwaikiki.advertservice.model.User;
import java.util.Objects;
import java.util.stream.Stream;

public class UserValidationUtil {

  public static boolean isValidForApplication(User user) {
    return Stream.of(
            user.getFirstname(), user.getLastname(), user.getAboutUser(), user.getDistrict(),
            user.getEmail(), user.getPhoneNumber(), user.getProvince(), user.getCv(),
            user.getProvinceID(), user.getGender(), user.getExperience())
        .allMatch(Objects::nonNull);
  }
}
