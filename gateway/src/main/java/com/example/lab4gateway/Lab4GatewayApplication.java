package com.example.lab4gateway;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;




@SpringBootApplication
public class Lab4GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${restaurant.dishtype.url}") String dishTypeUrl,
            @Value("${restaurant.menuitem.url}") String menuItemUrl,
            @Value("${restaurant.gateway.host}") String host
    ) {
        return builder
                .routes()
                .route("menu-items", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/menu-items/**"
                        )
                        .uri(menuItemUrl)
                )
                .route("dish-types", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/dish-types/**"
                        )
                        .uri(dishTypeUrl)
                )
                .build();
    }

    @Bean
    public CorsWebFilter corsWebFilter() {

        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }

}
