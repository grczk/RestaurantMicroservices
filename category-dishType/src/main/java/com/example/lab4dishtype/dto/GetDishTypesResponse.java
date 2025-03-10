package com.example.lab4dishtype.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class GetDishTypesResponse {
    @Data
    @Builder
    public static class DishType {
        private UUID id;
        private String name;

    }

    @Singular
    private List<DishType> dishTypes;
}
