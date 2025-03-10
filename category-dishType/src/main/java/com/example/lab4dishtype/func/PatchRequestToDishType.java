package com.example.lab4dishtype.func;

import com.example.lab4dishtype.entity.DishType;
import com.example.lab4dishtype.dto.PutPatchDishTypeRequest;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class PatchRequestToDishType implements BiFunction<DishType, PutPatchDishTypeRequest, DishType> {

    @Override
    public DishType apply(DishType entity, PutPatchDishTypeRequest request) {
        return DishType.builder()
                .id(entity.getId())
                .name(request.getName())
                .number(request.getNumber())
                .build();
    }
}
