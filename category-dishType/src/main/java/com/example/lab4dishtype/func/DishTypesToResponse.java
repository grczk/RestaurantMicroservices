package com.example.lab4dishtype.func;

import com.example.lab4dishtype.dto.GetDishTypesResponse;
import com.example.lab4dishtype.entity.DishType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class DishTypesToResponse implements Function<List<DishType>, GetDishTypesResponse> {
    @Override
    public GetDishTypesResponse apply(List<DishType> dishTypes) {
        return GetDishTypesResponse.builder()
                .dishTypes(dishTypes.stream()
                        .map(dishType -> GetDishTypesResponse.DishType.builder()
                                .id(dishType.getId())
                                .name(dishType.getName())
                                .build())
                        .toList())
                .build();
    }
}
