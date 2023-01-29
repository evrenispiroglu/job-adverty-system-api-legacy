package dev.ispiroglu.jobadvertysystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@Slf4j
public class TestController {
  @GetMapping
  public void log() {
    log.info("Test Log");
  }
}
