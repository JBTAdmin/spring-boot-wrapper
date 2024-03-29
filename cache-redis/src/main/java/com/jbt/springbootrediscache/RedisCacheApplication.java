package com.jbt.springbootrediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@SpringBootApplication
@EnableScheduling
public class RedisCacheApplication {

  public static void main(String[] args) {
    SpringApplication.run(RedisCacheApplication.class, args);
  }
}
