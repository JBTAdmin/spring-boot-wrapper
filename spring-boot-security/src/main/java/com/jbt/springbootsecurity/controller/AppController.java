package com.jbt.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/user")
    public String userget() {
        return "Hello User Role";
    }

    @GetMapping("/admin")
    public String adminGet() {
        return "Hello Admin Role";
    }
}
