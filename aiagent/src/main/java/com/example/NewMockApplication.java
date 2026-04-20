package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example", "ltss"})
public class NewMockApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewMockApplication.class, args);
    }
}
