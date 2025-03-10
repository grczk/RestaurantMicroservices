package com.example.lab4menuitem.func;

import com.example.lab4menuitem.entity.DishType;
import com.example.lab4menuitem.entity.MenuItem;
import com.example.lab4menuitem.dto.PutMenuItemRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PutRequestToMenuItem implements Function<PutMenuItemRequest, MenuItem> {

    @Override
    public MenuItem apply(PutMenuItemRequest request) {
        return MenuItem.builder()
                .name(request.getName())
                .price(request.getPrice())
                .dishType(DishType.builder().id(request.getDishTypeId()).build())
                .build();
    }
}
