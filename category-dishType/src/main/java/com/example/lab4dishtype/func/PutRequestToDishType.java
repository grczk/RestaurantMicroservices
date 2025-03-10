package com.example.lab4dishtype.func;

import com.example.lab4dishtype.entity.DishType;
import com.example.lab4dishtype.dto.PutPatchDishTypeRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class PutRequestToDishType implements Function<PutPatchDishTypeRequest, DishType> {

    @Override
    public DishType apply(PutPatchDishTypeRequest request) {
        return DishType.builder()
                .id((UUID.randomUUID()))
                .name(request.getName())
                .number(request.getNumber())
                .build();
    }
}
