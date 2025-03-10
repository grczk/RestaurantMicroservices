package com.example.lab4dishtype.dto;

import lombok.Data;

@Data
public class PutPatchDishTypeRequest {
    private String name;
    private int number;
}