package dev.ispiroglu.jobadvertysystem.dto.request.advert;

import dev.ispiroglu.jobadvertysystem.dto.model.advert.DashboardAdvertTableInfoDto;
import java.util.List;

public class GetDashboardInfosRequest {

  private Long totalAdvertCount;
  private Long totalUserCount;
  private Long totalEventCount;
  private List<DashboardAdvertTableInfoDto> soonEndingAdverts;
  private List<DashboardAdvertTableInfoDto> soonStartingAdverts;

  public GetDashboardInfosRequest(Long totalAdvertCount, Long totalUserCount, Long totalEventCount,
                                  List<DashboardAdvertTableInfoDto> soonEndingAdverts,
                                  List<DashboardAdvertTableInfoDto> soonStartingAdverts) {
    this.totalAdvertCount = totalAdvertCount;
    this.totalUserCount = totalUserCount;
    this.totalEventCount = totalEventCount;
    this.soonEndingAdverts = soonEndingAdverts;
    this.soonStartingAdverts = soonStartingAdverts;
  }

  public Long getTotalAdvertCount() {
    return totalAdvertCount;
  }

  public Long getTotalUserCount() {
    return totalUserCount;
  }

  public Long getTotalEventCount() {
    return totalEventCount;
  }

  public List<DashboardAdvertTableInfoDto> getSoonEndingAdverts() {
    return soonEndingAdverts;
  }

  public List<DashboardAdvertTableInfoDto> getSoonStartingAdverts() {
    return soonStartingAdverts;
  }
}
