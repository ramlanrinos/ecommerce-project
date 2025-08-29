package com.rinos.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) // for block the security service temporary
public class EcommerceProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceProjectApplication.class, args);
    }

}
