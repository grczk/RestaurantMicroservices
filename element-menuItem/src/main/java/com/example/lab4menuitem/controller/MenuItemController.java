package com.example.lab4menuitem.controller;

import com.example.lab4menuitem.dto.GetMenuItemsResponse;
import com.example.lab4menuitem.entity.DishType;
import com.example.lab4menuitem.entity.MenuItem;
import com.example.lab4menuitem.dto.GetMenuItemResponse;
import com.example.lab4menuitem.dto.PatchMenuItemRequest;
import com.example.lab4menuitem.dto.PutMenuItemRequest;
import com.example.lab4menuitem.func.MenuItemToResponse;
import com.example.lab4menuitem.func.MenuItemsToResponse;
import com.example.lab4menuitem.func.PatchRequestToMenuItem;
import com.example.lab4menuitem.func.PutRequestToMenuItem;
import com.example.lab4menuitem.service.DishTypeService;
import com.example.lab4menuitem.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {
    private MenuItemService service;
    private DishTypeService dishTypeService;
    private MenuItemToResponse menuItemToResponse;
    private MenuItemsToResponse menuItemsToResponse;
    private PutRequestToMenuItem putRequestToMenuItem;
    private PatchRequestToMenuItem patchRequestToMenuItem;
    @Autowired
    public MenuItemController(MenuItemService service,
                              MenuItemToResponse menuItemToResponse,
                              MenuItemsToResponse menuItemsToResponse,
                              PutRequestToMenuItem putRequestToMenuItem,
                              DishTypeService dishTypeService,
                              PatchRequestToMenuItem patchRequestToMenuItem) {
        this.service = service;
        this.menuItemToResponse= menuItemToResponse;
        this.menuItemsToResponse= menuItemsToResponse;
        this.putRequestToMenuItem = putRequestToMenuItem;
        this.dishTypeService = dishTypeService;
        this.patchRequestToMenuItem = patchRequestToMenuItem;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetMenuItemResponse getMenuItemById(@PathVariable("id") UUID id) {
        return service.findById(id)
                .map(menuItemToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetMenuItemsResponse getAllMenuItems() {
        return menuItemsToResponse.apply(service.findAll());
    }

    @GetMapping("/from/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetMenuItemsResponse getMenuItemsFromDishType(@PathVariable("id") UUID id) {
        return service.findAllByDishType(id).map(menuItemsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No menu items found for the specified dish type"));
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    void putMenuItem(@RequestBody PutMenuItemRequest request){
        MenuItem newMenuItem = putRequestToMenuItem.apply(request);
        service.save(newMenuItem);
    }


    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void patchMenuItem(@PathVariable("id") UUID id, @RequestBody PatchMenuItemRequest request) {
        MenuItem existingMenuItem = service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        MenuItem updatedMenuItem = patchRequestToMenuItem.apply(existingMenuItem, request);
        service.save(updatedMenuItem);
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
