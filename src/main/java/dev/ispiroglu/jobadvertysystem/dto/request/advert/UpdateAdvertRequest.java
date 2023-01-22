package dev.ispiroglu.jobadvertysystem.dto.request.advert;

public class UpdateAdvertRequest {


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

  private boolean active;

//  private byte[] photo;

  private String companyName;

  private String department;

//  public UpdateAdvertRequest(String name, String summary, Date startDate, Date endDate,
//      String position, int capacity, String district, String province, int provinceID,
//      String jobDefinition, boolean active, String companyName,
//      String department) {
//    this.name = name;
//    this.summary = summary;
//    this.startDate = startDate;
//    this.endDate = endDate;
//    this.position = position;
//    this.capacity = capacity;
//    this.district = district;
//    this.province = province;
//    this.provinceID = provinceID;
//    this.jobDefinition = jobDefinition;
//    this.active = active;
////    this.photo = photo;
//    this.companyName = companyName;
//    this.department = department;
//  }


  public UpdateAdvertRequest(String name, String summary, String startDate, String endDate,
      String position, int capacity, String district, String province, int provinceID,
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

  public String getName() {
    return name;
  }

  public String getSummary() {
    return summary;
  }

//  public Date getStartDate() {
//    return startDate;
//  }

//  public Date getEndDate() {
//    return endDate;
//  }


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

  public boolean isActive() {
    return active;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getDepartment() {
    return department;
  }

//  public byte[] getPhoto() {
//    return photo;
//  }


  @Override
  public String toString() {
    return "UpdateAdvertRequest{" +
        "name='" + name + '\'' +
        ", summary='" + summary + '\'' +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", position='" + position + '\'' +
        ", capacity=" + capacity +
        ", district='" + district + '\'' +
        ", province='" + province + '\'' +
        ", provinceID=" + provinceID +
        ", jobDefinition='" + jobDefinition + '\'' +
        ", active=" + active +
        ", companyName='" + companyName + '\'' +
        ", department='" + department + '\'' +
        '}';
  }
}
