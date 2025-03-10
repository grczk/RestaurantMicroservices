package com.example.lab4menuitem.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class GetMenuItemsResponse
{
    @Data
    @Builder
    public static class MenuItem {
        private UUID id;
        private String name;

    }
        @Singular
        private List<MenuItem> menuItems;
}
