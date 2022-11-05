package com.lcwaikiki.advertservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Advert {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column
  private String summary;
  @Column
  private Date startDate;
  @Column
  private Date endDate;
  @Column
  private String position;
  @Column
  private int capacity;
  @Column
  private String district;
  @Column
  private String province;
  @Column
  private int provinceID;
  @Column
  private String jobDefinition;
  @Column
  private boolean active;
  @Lob
  private byte[] photo;
  @Column
  private String companyName;
  @Column
  private String department;
  @CreationTimestamp
  private LocalDateTime creationDate;
  @UpdateTimestamp
  private LocalDateTime update;
  @OneToMany(mappedBy = "advert")
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  private Set<ApplicationDetail> applications;

  @OneToOne(mappedBy = "advert")
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  private AdvertOwner advertOwner;


  public Advert(Long id, String name, String summary, Date startDate, Date endDate,
      String position, int capacity, String district, String province, int provinceID,
      String jobDefinition, boolean active, byte[] photo, String companyName,
      String department, LocalDateTime creationDate, LocalDateTime update,
      Set<ApplicationDetail> applications) {
    this.id = id;
    this.name = name;
    this.summary = summary;
    this.startDate = startDate;
    this.endDate = endDate;
    this.position = position;
    this.capacity = capacity;
    this.district = district;
    this.province = province;
    this.provinceID = provinceID;
    this.jobDefinition = jobDefinition;
    this.active = active;
    this.photo = photo;
    this.companyName = companyName;
    this.department = department;
    this.creationDate = creationDate;
    this.update = update;
    this.applications = applications;
  }

  public Advert() {

  }

  public Advert(String name, String summary, Date startDate, Date endDate, String position,
      int capacity, String district, String province, int provinceID, String jobDefinition,
      boolean active, byte[] photo, String companyName, String department) {
    this.name = name;
    this.summary = summary;
    this.startDate = startDate;
    this.endDate = endDate;
    this.position = position;
    this.capacity = capacity;
    this.district = district;
    this.province = province;
    this.provinceID = provinceID;
    this.jobDefinition = jobDefinition;
    this.active = active;
    this.photo = photo;
    this.companyName = companyName;
    this.department = department;
  }

  public Advert(String name, String summary, Date startDate, Date endDate, String position,
      int capacity, String district, String province, int provinceID,
      String jobDefinition, boolean active, String companyName, String department,
      AdvertOwner advertOwner) {
    this.name = name;
    this.summary = summary;
    this.startDate = startDate;
    this.endDate = endDate;
    this.position = position;
    this.capacity = capacity;
    this.district = district;
    this.province = province;
    this.provinceID = provinceID;
    this.jobDefinition = jobDefinition;
    this.active = active;
    this.companyName = companyName;
    this.department = department;
    this.advertOwner = advertOwner;
  }

  public Advert(String name, String summary, Date startDate, Date endDate, String position,
      int capacity, String district, String province, int provinceID,
      String jobDefinition, boolean active, String companyName, String department) {
    this.name = name;
    this.summary = summary;
    this.startDate = startDate;
    this.endDate = endDate;
    this.position = position;
    this.capacity = capacity;
    this.district = district;
    this.province = province;
    this.provinceID = provinceID;
    this.jobDefinition = jobDefinition;
    this.active = active;
    this.companyName = companyName;
    this.department = department;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
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

  public String getJobDefinition() {
    return jobDefinition;
  }

  public void setJobDefinition(String jobDefinition) {
    this.jobDefinition = jobDefinition;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public byte[] getPhoto() {
    return photo;
  }

  public void setPhoto(byte[] photoUrl) {
    this.photo = photoUrl;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public Set<ApplicationDetail> getApplications() {
    return applications;
  }

  public void setApplications(
      Set<ApplicationDetail> applications) {
    this.applications = applications;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public LocalDateTime getUpdate() {
    return update;
  }

  public void setUpdate(LocalDateTime update) {
    this.update = update;
  }


  public AdvertOwner getAdvertOwner() {
    return advertOwner;
  }

  public void setAdvertOwner(AdvertOwner advertOwner) {
    this.advertOwner = advertOwner;
  }

  public Advert updateAdvert(Advert baseAdvert, Advert newAdvert) {
    baseAdvert.setName(newAdvert.getName());
    return baseAdvert;
  }

  public void addApplication(ApplicationDetail application) {
    applications.add(application);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Advert advert = (Advert) o;
    return capacity == advert.capacity && provinceID == advert.provinceID
        && active == advert.active && id.equals(advert.id) && name.equals(advert.name)
        && summary.equals(advert.summary) && startDate.equals(advert.startDate)
        && endDate.equals(advert.endDate) && position.equals(advert.position)
        && district.equals(advert.district) && province.equals(advert.province)
        && jobDefinition.equals(advert.jobDefinition) && photo.equals(advert.photo)
        && companyName.equals(advert.companyName) && department.equals(advert.department)
        && applications.equals(advert.applications);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, summary, startDate, endDate, position, capacity, district,
        province, provinceID, jobDefinition, active, photo, companyName, department,
        applications);
  }

  @Override
  public String toString() {
    return "Advert{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", summary='" + summary + '\'' +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", position='" + position + '\'' +
        ", capacity=" + capacity +
        ", district='" + district + '\'' +
        ", province='" + province + '\'' +
        ", provinceID=" + provinceID +
        ", jobDefinition='" + jobDefinition + '\'' +
        ", isActive=" + active +
        ", photoUrl='" + photo + '\'' +
        ", companyName='" + companyName + '\'' +
        ", department='" + department + '\'' +
        ", applicants=" + applications +
        '}';
  }
}
