package com.jbt.springbootsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/user/")
    public String userget() {
        return "User accessed it";
    }

    @GetMapping("/admin/hello")
    public String adminGet() {

        return "admin accessed it";
    }
}
