package com.example.lab4dishtype.repository;

import com.example.lab4dishtype.entity.DishType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import java.util.UUID;

@Repository
public class DishTypeEventRestRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public DishTypeEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void delete(UUID id) {
        restTemplate.delete("/api/dish-types/{id}", id);
    }

    public void save(UUID id) {
        restTemplate.put("/api/dish-types/" + id, id);
    }

}
