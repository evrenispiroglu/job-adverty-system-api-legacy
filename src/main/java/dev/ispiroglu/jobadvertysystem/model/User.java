package dev.ispiroglu.jobadvertysystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "[user]")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstname;
  private String lastname;
  private String gender;
  @Column(unique = true)
  private String email;
  private String password;
  private String phoneNumber;
  private String province;
  private int provinceID;
  private String district;
  private int experience;
  private String aboutUser;
  private boolean isEmployer;
  @CreationTimestamp
  private LocalDateTime creationDate;
  @UpdateTimestamp
  private LocalDateTime update;
  @OneToMany(mappedBy = "user")
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  private Set<ApplicationDetail> applications;
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  private Set<AdvertOwner> ownedAdverts;
  @Lob
  private byte[] profilePhoto;
  @Lob
  private byte[] cv;

  public User(Long id, String firstname, String lastname, String gender, String email,
              String password, String phoneNumber, String province, int provinceID, String district,
              int experience, String aboutUser, boolean isEmployer, LocalDateTime creationDate,
              LocalDateTime update, Set<ApplicationDetail> applications, byte[] profilePhoto,
              byte[] cv) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.gender = gender;
    this.email = email;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.province = province;
    this.provinceID = provinceID;
    this.district = district;
    this.experience = experience;
    this.aboutUser = aboutUser;
    this.isEmployer = isEmployer;
    this.creationDate = creationDate;
    this.update = update;
    this.applications = applications;
    this.profilePhoto = profilePhoto;
    this.cv = cv;
  }

  public User(boolean isEmployer, String email, String password, String firstname,
              String lastname) {
    this.isEmployer = isEmployer;
    this.email = email;
    this.password = password;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public User() {

  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public int getProvinceID() {
    return provinceID;
  }

  public void setProvinceID(int provinceID) {
    this.provinceID = provinceID;
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

  public Set<ApplicationDetail> getApplications() {
    return applications;
  }

  public void setApplications(
      Set<ApplicationDetail> applications) {
    this.applications = applications;
  }

  public boolean isEmployer() {
    return isEmployer;
  }

  public void setEmployer(boolean employer) {
    isEmployer = employer;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", firstname='" + firstname + '\'' +
        ", lastname='" + lastname + '\'' +
        ", gender='" + gender + '\'' +
        ", email='" + email + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", province='" + province + '\'' +
        ", provinceID=" + provinceID +
        ", district='" + district + '\'' +
        ", experience=" + experience +
        ", aboutUser='" + aboutUser + '\'' +
        ", applicationDetails=" + applications +
//        ", applicationDetails=" + applicationDetails +
        '}';
  }

  public LocalDateTime getUpdate() {
    return update;
  }

  public void setUpdate(LocalDateTime update) {
    this.update = update;
  }

  public void addApplication(ApplicationDetail application) {
    applications.add(application);
  }

  public void addOwnedAdvert(AdvertOwner ownedAdvert) {
    ownedAdverts.add(ownedAdvert);
  }

  public byte[] getProfilePhoto() {
    return profilePhoto;
  }

  public void setProfilePhoto(byte[] profilePhoto) {
    this.profilePhoto = profilePhoto;
  }

  public byte[] getCv() {
    return cv;
  }

  public void setCv(byte[] cv) {
    this.cv = cv;
  }

  public Set<AdvertOwner> getOwnedAdverts() {
    return ownedAdverts;
  }


  public void setOwnedAdverts(Set<AdvertOwner> ownedAdverts) {
    this.ownedAdverts = ownedAdverts;
  }
}
