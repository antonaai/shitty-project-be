package com.example.cleaning;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.cleaning")
public class CleaningApplication {
    public static void main(String[] args) {
        SpringApplication.run(CleaningApplication.class, args);
    }
}
