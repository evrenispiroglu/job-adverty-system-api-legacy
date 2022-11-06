package dev.ispiroglu.jobadvertysystem.dto.converter;

import dev.ispiroglu.jobadvertysystem.dto.model.user.UserCredentialDto;
import dev.ispiroglu.jobadvertysystem.dto.response.user.AdvertAppliedUserInfoResponse;
import dev.ispiroglu.jobadvertysystem.dto.response.user.UserDetailResponse;
import dev.ispiroglu.jobadvertysystem.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

  public UserCredentialDto convertToUserCredentialDto(User from) {
    return new UserCredentialDto(
        from.getId(),
        from.isEmployer(),
        from.getEmail(),
        from.getPassword(),
        from.getCreationDate()
    );
  }

  public UserDetailResponse convertToUserDetailsDto(User from) {
    return new UserDetailResponse(
        from.getId(), from.getFirstname(), from.getLastname(),
        from.getGender(), from.getEmail(),
        from.getPhoneNumber(), from.getProvince(),
        from.getProvinceID(), from.getDistrict(), from.getExperience(), from.getAboutUser()
    );
  }

  public AdvertAppliedUserInfoResponse convertToAdvertAppliedUserInfoResponse(User from) {
    return new AdvertAppliedUserInfoResponse(
        from.getId(), from.getFirstname(), from.getLastname(),
        from.getEmail(), from.getExperience(), from.getDistrict() + "/" + from.getProvince()
    );
  }

  /*
   * Should implement
   *    convertToUserCVDto
   *    convertToUserPhotoDto
   *    convertToUserApplicationsDto
   * */
}
