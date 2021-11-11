package com.jbt.oauth.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @GetMapping("/admin")
  public String adminAccess(Principal principal) {
    return "Hello!!" + principal.getName();
  }

  @GetMapping("/")
  public String allAccess(Principal principal) {
    return "Hello!!" + principal.getName();
  }
}
