package dev.ispiroglu.jobadvertysystem.dto.response.advert;

import dev.ispiroglu.jobadvertysystem.dto.model.advert.DashboardAdvertTableInfoDto;
import java.util.List;

public class DashboardInfoResponse {

  private Long totalAdvertCount;
  private Long totalApplicationCount;
  private Long totalUserCount;
  private List<DashboardAdvertTableInfoDto> soonEndingAdverts;
  private List<DashboardAdvertTableInfoDto> soonStartingAdverts;

  public DashboardInfoResponse(Long totalAdvertCount, Long totalApplicationCount,
      Long totalUserCount,
      List<DashboardAdvertTableInfoDto> soonEndingAdverts,
      List<DashboardAdvertTableInfoDto> soonStartingAdverts) {
    this.totalAdvertCount = totalAdvertCount;
    this.totalApplicationCount = totalApplicationCount;
    this.totalUserCount = totalUserCount;
    this.soonEndingAdverts = soonEndingAdverts;
    this.soonStartingAdverts = soonStartingAdverts;
  }

  public Long getTotalAdvertCount() {
    return totalAdvertCount;
  }

  public Long getTotalApplicationCount() {
    return totalApplicationCount;
  }

  public Long getTotalUserCount() {
    return totalUserCount;
  }

  public List<DashboardAdvertTableInfoDto> getSoonEndingAdverts() {
    return soonEndingAdverts;
  }

  public List<DashboardAdvertTableInfoDto> getSoonStartingAdverts() {
    return soonStartingAdverts;
  }
}
