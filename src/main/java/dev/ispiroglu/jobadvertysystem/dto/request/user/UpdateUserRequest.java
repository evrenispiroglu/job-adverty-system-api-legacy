package dev.ispiroglu.jobadvertysystem.dto.request.user;

public class UpdateUserRequest {

  private String firstname;
  private String lastname;
  private String gender;
  private String email;
  private String phoneNumber;
  private String province;
  private int provinceID;
  private String district;
  private int experience;
  private String aboutUser;

  public UpdateUserRequest(String firstname, String lastname, String gender, String email,
                           String phoneNumber, String province, int provinceID, String district,
                           int experience,
                           String aboutUser) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.gender = gender;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.province = province;
    this.provinceID = provinceID;
    this.district = district;
    this.experience = experience;
    this.aboutUser = aboutUser;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public int getExperience() {
    return experience;
  }

  public void setExperience(int experience) {
    this.experience = experience;
  }

  public String getAboutUser() {
    return aboutUser;
  }

  public void setAboutUser(String aboutUser) {
    this.aboutUser = aboutUser;
  }

  @Override
  public String toString() {
    return "UpdateUserRequest{" +
        "firstname='" + firstname + '\'' +
        ", lastname='" + lastname + '\'' +
        ", gender='" + gender + '\'' +
        ", email='" + email + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", province='" + province + '\'' +
        ", district='" + district + '\'' +
        ", experience=" + experience +
        ", aboutUser='" + aboutUser + '\'' +
        '}';
  }

  public int getProvinceID() {
    return provinceID;
  }

  public void setProvinceID(int provinceID) {
    this.provinceID = provinceID;
  }
}
