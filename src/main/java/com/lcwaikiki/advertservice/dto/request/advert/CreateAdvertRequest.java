package com.lcwaikiki.advertservice.dto.request.advert;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class CreateAdvertRequest {

  @NotNull
  @NotEmpty
  private String name;
  @NotNull
  @NotEmpty
  private String summary;
  @NotNull
  @NotEmpty
  private Date startDate;
  @NotNull
  @NotEmpty
  private Date endDate;
  @NotNull
  @NotEmpty
  private String position;
  @NotNull
  @NotEmpty
  private int capacity;
  @NotNull
  @NotEmpty
  private String district;
  @NotNull
  @NotEmpty
  private String province;
  @NotNull
  @NotEmpty
  private int provinceID;
  @NotNull
  @NotEmpty
  private String jobDefinition;
  //  @NotNull
//  @NotEmpty
//  private byte[] photo;
  @NotNull
  @NotEmpty
  private String companyName;
  @NotNull
  @NotEmpty
  private String department;


  public CreateAdvertRequest(String name, String summary, Date startDate, Date endDate,
      String position, int capacity, String district, String province, int provinceID,
      String jobDefinition,
//      byte[] photo,
      String companyName,
      String department) {
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
//    this.photo = photo;
    this.companyName = companyName;
    this.department = department;
  }


  public String getName() {
    return name;
  }

  public String getSummary() {
    return summary;
  }

  public Date getStartDate() {
    return startDate;
  }

  public Date getEndDate() {
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

//  public byte[] getPhoto() {
//    return photo;
//  }

  public String getCompanyName() {
    return companyName;
  }

  public String getDepartment() {
    return department;
  }
}
