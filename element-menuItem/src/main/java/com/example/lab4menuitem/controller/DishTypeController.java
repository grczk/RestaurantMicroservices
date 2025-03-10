package com.example.lab4menuitem.controller;

import com.example.lab4menuitem.entity.DishType;
import com.example.lab4menuitem.dto.*;
import com.example.lab4menuitem.func.*;
import com.example.lab4menuitem.repository.DishTypeRepository;
import com.example.lab4menuitem.service.DishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/dish-types")
public class DishTypeController {

    private DishTypeService service;
    @Autowired
    public DishTypeController(DishTypeService service)
    {
        this.service=service;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMenuItem(@PathVariable("id") UUID id){
        service.findById(id)
                .ifPresentOrElse(
                        character -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putDishType(@PathVariable("id") UUID id){
        service.save(id);
    }
}

