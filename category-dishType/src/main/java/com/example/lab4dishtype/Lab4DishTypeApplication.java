package com.example.lab4dishtype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Lab4DishTypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4DishTypeApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(@Value("${restaurant.menuitem.url}") String baseUrl) {
        return new RestTemplateBuilder().rootUri(baseUrl).build();
    }

}

