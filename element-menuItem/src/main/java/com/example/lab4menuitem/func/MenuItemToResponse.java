package com.example.lab4menuitem.func;

import com.example.lab4menuitem.entity.MenuItem;
import com.example.lab4menuitem.dto.GetMenuItemResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MenuItemToResponse implements Function<MenuItem, GetMenuItemResponse> {
    @Override
    public GetMenuItemResponse apply(MenuItem menuItem) {
        return GetMenuItemResponse.builder()
                .id(menuItem.getId())
                .name(menuItem.getName())
                .price(menuItem.getPrice())
                .dishTypeId(menuItem.getDishType().getId())
                .build();
    }

}
