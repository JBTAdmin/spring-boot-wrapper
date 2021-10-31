package com.example.springbootrest.controller;

import com.example.springbootrest.dto.ResponseDto;
import com.example.springbootrest.gateway.Gateway;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {

    private final Gateway gateway;

    @GetMapping("/hello")
    public ResponseDto hello() {
        return gateway.get();
    }

}
