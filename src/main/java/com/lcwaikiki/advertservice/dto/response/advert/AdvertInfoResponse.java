package com.lcwaikiki.advertservice.dto.response.advert;

public class AdvertInfoResponse {

  private Long id;
  private String name;
  private String summary;
  private String startDate;
  private String endDate;
  private String position;
  private int capacity;
  private String district;
  private String province;
  private int provinceID;
  private String jobDefinition;
  private boolean isOpen;
  private String department;
  private String companyName;

  public AdvertInfoResponse(Long id, String name, String summary, String startDate,
      String endDate, String position, int capacity, String district, String province,
      int provinceID, String jobDefinition, boolean isOpen, String companyName, String department) {
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
    this.isOpen = isOpen;
    this.department = department;
    this.companyName = companyName;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSummary() {
    return summary;
  }

  public String getStartDate() {
    return startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public String getPosition() {
    return position;
  }

  public int getCapacity() {
    return capacity;
  }

  public String getDistrict() {
    return district;
  }

  public String getProvince() {
    return province;
  }

  public int getProvinceID() {
    return provinceID;
  }

  public String getJobDefinition() {
    return jobDefinition;
  }

  public boolean getIsOpen() {
    return isOpen;
  }

  public String getDepartment() {
    return department;
  }

  public boolean isOpen() {
    return isOpen;
  }

  public String getCompanyName() {
    return companyName;
  }
}
