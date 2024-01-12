package com.example.bugtracker.API;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BugTrackerAPI {

  @GetMapping(value = "/test")
  public String test() {
    return "successful";
  }

}
