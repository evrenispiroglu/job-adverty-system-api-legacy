package com.lcwaikiki.advertservice.controller;

import com.lcwaikiki.advertservice.dto.response.advert.DashboardInfoResponse;
import com.lcwaikiki.advertservice.exception.UserNotFoundException;
import com.lcwaikiki.advertservice.service.OperationHandlerService;
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
