package dev.ispiroglu.jobadvertysystem.dto.request.advert;

public class GetFilteredAdvertsRequest {

  private String searchText;
  private String department;
  private String position;
  private String province;

  public GetFilteredAdvertsRequest(String searchText, String department, String position,
                                   String province) {
    this.searchText = searchText;
    this.department = department;
    this.position = position;
    this.province = province;
  }

  public String getSearchText() {
    return searchText;
  }

  public String getDepartment() {
    return department;
  }

  public String getPosition() {
    return position;
  }

  public String getProvince() {
    return province;
  }

  @Override
  public String toString() {
    return "GetFilteredAdvertsRequest{" +
        "searchText='" + searchText + '\'' +
        ", department='" + department + '\'' +
        ", position='" + position + '\'' +
        ", province='" + province + '\'' +
        '}';
  }
}
