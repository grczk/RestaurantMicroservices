package com.example.lab4dishtype.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetDishTypeResponse {
    private UUID id;
    private String name;
    private int number;
}