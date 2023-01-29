package dev.ispiroglu.jobadvertysystem.dto.model.advert;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AdvertDetailsDto {

  @NotNull
  @NotEmpty
  private Long id;
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
  @NotNull
  @NotEmpty
  private boolean isActive;
  @NotNull
  @NotEmpty
  private String companyName;
  @NotNull
  @NotEmpty
  private String department;


  public AdvertDetailsDto(Long id, String name, String summary, Date startDate, Date endDate,
                          String position, int capacity, String district, String province,
                          int provinceID,
                          String jobDefinition, boolean isActive, String companyName,
                          String department) {
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
    this.isActive = isActive;
    this.companyName = companyName;
    this.department = department;
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

  public boolean isActive() {
    return isActive;
  }


  public String getCompanyName() {
    return companyName;
  }

  public String getDepartment() {
    return department;
  }
}
