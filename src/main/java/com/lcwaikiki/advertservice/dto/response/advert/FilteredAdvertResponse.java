package com.lcwaikiki.advertservice.dto.response.advert;

import com.lcwaikiki.advertservice.model.ApplicationDetail;
import java.util.Date;
import java.util.Set;

public class FilteredAdvertResponse {

  private Long id;

  private String name;

  private String summary;

  private Date startDate;

  private Date endDate;

  private String position;

  private int capacity;

  private String district;

  private String province;

  private int provinceID;

  private String jobDefinition;

  private boolean active;

  private byte[] photo;

  private String companyName;

  private String department;
  private Set<ApplicationDetail> applications;

  public FilteredAdvertResponse(Long id, String name, String summary, Date startDate, Date endDate,
      String position, int capacity, String district, String province, int provinceID,
      String jobDefinition, boolean active, byte[] photo, String companyName,
      String department, Set<ApplicationDetail> applications) {
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
    this.applications = applications;
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

  public void setPhoto(byte[] photo) {
    this.photo = photo;
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
}
