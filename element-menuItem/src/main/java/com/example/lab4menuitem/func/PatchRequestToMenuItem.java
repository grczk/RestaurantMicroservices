package com.example.lab4menuitem.func;

import com.example.lab4menuitem.entity.MenuItem;
import com.example.lab4menuitem.dto.PatchMenuItemRequest;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class PatchRequestToMenuItem implements BiFunction<MenuItem, PatchMenuItemRequest, MenuItem> {

    @Override
    public MenuItem apply(MenuItem entity, PatchMenuItemRequest request) {
        return MenuItem.builder()
                .id(entity.getId())
                .name(request.getName())
                .price(request.getPrice())
                .dishType(entity.getDishType())
                .build();
    }
}
