package com.example.lab4dishtype.func;

import com.example.lab4dishtype.entity.DishType;
import com.example.lab4dishtype.dto.GetDishTypeResponse;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class DishTypeToResponse implements Function<DishType, GetDishTypeResponse> {
    @Override
    public GetDishTypeResponse apply(DishType dishType) {
        return GetDishTypeResponse.builder()
                .id(dishType.getId())
                .name(dishType.getName())
                .number(dishType.getNumber())
                .build();
    }
}
