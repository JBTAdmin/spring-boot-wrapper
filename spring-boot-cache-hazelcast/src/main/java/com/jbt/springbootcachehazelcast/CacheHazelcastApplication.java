package com.jbt.springbootcachehazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CacheHazelcastApplication {

  public static void main(String[] args) {
    SpringApplication.run(CacheHazelcastApplication.class, args);
  }
}
