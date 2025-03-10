package com.example.lab4dishtype;

import com.example.lab4dishtype.service.DishTypeService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.lab4dishtype.entity.DishType;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final DishTypeService dishTypeService;

    @Autowired
    public InitializeData (DishTypeService dishTypeService)
    {
        this.dishTypeService=dishTypeService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        DishType breakfast = DishType.builder()
                .id(UUID.fromString("6ae31c53-5c3a-41b4-92ff-1ab9c42405f8"))
                .name("breakfast")
                .number(1)
                .build();
        DishType dessert = DishType.builder()
                .id(UUID.fromString("911128a2-cd28-49b1-93ce-6df720fd73da"))
                .name("dessert")
                .number(2)
                .build();
        DishType pasta = DishType.builder()
                .id(UUID.fromString("a80f3d25-c0f8-44e0-ab13-61deb5d48945"))
                .name("pasta")
                .number(3)
                .build();

        dishTypeService.create(breakfast);
        dishTypeService.create(dessert);
        dishTypeService.create(pasta);
    }
}
