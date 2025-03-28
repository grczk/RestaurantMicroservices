package com.example.lab4menuitem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Lab4MenuItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4MenuItemApplication.class, args);
    }

}
