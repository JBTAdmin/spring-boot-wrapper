package com.example.springbootrest.config;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
/**
 * Either Enable @Configuration annotation or use @EnableConfigurationProperties(RestConfig.class)
 */
//@Configuration
@ConfigurationProperties(prefix = "rest.api")
public class RestConfig {
    private String url;
}

