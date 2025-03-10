package com.example.lab4dishtype.controller;

import com.example.lab4dishtype.entity.DishType;
import com.example.lab4dishtype.dto.*;
import com.example.lab4dishtype.func.*;
import com.example.lab4dishtype.service.DishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/api/dish-types")
public class DishTypeController {

    private DishTypeService service;
    private DishTypeToResponse dishTypeToResponse;
    private DishTypesToResponse dishTypesToResponse;
    private PutRequestToDishType putRequestToDishType;
    private PatchRequestToDishType patchRequestToDishType;
    @Autowired
    public DishTypeController(DishTypeService service,
                              DishTypeToResponse dishTypeToResponse,
                              DishTypesToResponse dishTypesToResponse,
                              PutRequestToDishType putRequestToDishType,
                              PatchRequestToDishType patchRequestToDishType)
    {
        this.service=service;
        this.dishTypeToResponse= dishTypeToResponse;
        this.dishTypesToResponse= dishTypesToResponse;;
        this.putRequestToDishType = putRequestToDishType;
        this.patchRequestToDishType = patchRequestToDishType;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetDishTypeResponse getDishTypeById(@PathVariable("id") UUID id) {
        return service.findById(id)
                .map(dishTypeToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetDishTypesResponse getAllDishTypes() {
        return dishTypesToResponse.apply(service.findAll());
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    void putDishType(@RequestBody PutPatchDishTypeRequest request){
        service.save(putRequestToDishType.apply(request));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void patchDishType(@PathVariable("id") UUID id, @RequestBody PutPatchDishTypeRequest request) {
        DishType existingDishType = service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        DishType updatedDishType = patchRequestToDishType.apply(existingDishType, request);
        service.save(updatedDishType);
    }

    @DeleteMapping("{id}")
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
}

