package dev.ispiroglu.jobadvertysystem.dto.model.advert;

public class DashboardAdvertTableInfoDto {

  private String companyName;
  private String advertName;
  private String position;
  private String summary;
  private String location;

  public DashboardAdvertTableInfoDto(String companyName, String advertName, String position,
                                     String summary, String location) {
    this.companyName = companyName;
    this.advertName = advertName;
    this.position = position;
    this.summary = summary;
    this.location = location;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getAdvertName() {
    return advertName;
  }

  public String getPosition() {
    return position;
  }

  public String getSummary() {
    return summary;
  }

  public String getLocation() {
    return location;
  }
}
