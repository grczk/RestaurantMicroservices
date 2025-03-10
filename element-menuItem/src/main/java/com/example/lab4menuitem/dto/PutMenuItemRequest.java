package com.example.lab4menuitem.dto;


import lombok.Data;

import java.util.UUID;


@Data
public class PutMenuItemRequest {
    private String name;
    private double price;
    private UUID dishTypeId;
}