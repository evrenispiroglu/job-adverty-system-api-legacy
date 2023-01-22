package dev.ispiroglu.jobadvertysystem.controller;

import dev.ispiroglu.jobadvertysystem.dto.response.advert.DashboardInfoResponse;
import dev.ispiroglu.jobadvertysystem.exception.UserNotFoundException;
import dev.ispiroglu.jobadvertysystem.service.OperationHandlerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/dashboard")
public class Dashboard {

  private final OperationHandlerService service;

  public Dashboard(OperationHandlerService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<DashboardInfoResponse> getDashboardInfo(@RequestParam Long userID)
      throws UserNotFoundException {
    return ResponseEntity.ok(service.getDashboardInfoDto(userID));
  }
}
