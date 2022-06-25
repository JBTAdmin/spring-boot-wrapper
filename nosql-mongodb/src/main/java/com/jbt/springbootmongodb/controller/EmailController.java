package com.jbt.springbootmongodb.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

  @GetMapping
  public List<String> getAllEmails() {
    return null;
  }
}
