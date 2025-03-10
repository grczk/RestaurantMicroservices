package com.example.lab4menuitem.func;

import com.example.lab4menuitem.dto.GetMenuItemsResponse;
import com.example.lab4menuitem.entity.MenuItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class MenuItemsToResponse implements Function<List<MenuItem>, GetMenuItemsResponse> {
    @Override
    public GetMenuItemsResponse apply(List<MenuItem> menuItems) {
        return GetMenuItemsResponse.builder()
                .menuItems(menuItems.stream()
                        .map(menuItem -> GetMenuItemsResponse.MenuItem.builder()
                                .id(menuItem.getId())
                                .name(menuItem.getName())
                                .build())
                        .toList())
                .build();
    }
}
