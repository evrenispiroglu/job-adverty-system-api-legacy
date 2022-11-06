package dev.ispiroglu.jobadvertysystem.dto.response.user;

public class UserInfoResponse {

  private Long id;
  private byte[] cv;
  private byte[] profilePhoto;
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

  public UserInfoResponse(Long id, byte[] cv, byte[] profilePhoto, String firstname,
      String lastname,
      String gender, String email, String phoneNumber, String province, int provinceID,
      String district, int experience, String aboutUser) {
    this.id = id;
    this.cv = cv;
    this.profilePhoto = profilePhoto;
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

  public Long getId() {
    return id;
  }

  public byte[] getCv() {
    return cv;
  }

  public byte[] getProfilePhoto() {
    return profilePhoto;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getGender() {
    return gender;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getProvince() {
    return province;
  }

  public int getProvinceID() {
    return provinceID;
  }

  public String getDistrict() {
    return district;
  }

  public int getExperience() {
    return experience;
  }

  public String getAboutUser() {
    return aboutUser;
  }
}
