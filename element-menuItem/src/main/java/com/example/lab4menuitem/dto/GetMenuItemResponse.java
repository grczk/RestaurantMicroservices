package com.example.lab4menuitem.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Builder
@Data
public class GetMenuItemResponse {
    private UUID id;
    private String name;
    private double price;
    private UUID dishTypeId;
}