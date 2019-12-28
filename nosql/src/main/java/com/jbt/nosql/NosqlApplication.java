package com.jbt.nosql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class NosqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(NosqlApplication.class, args);
    }

}
