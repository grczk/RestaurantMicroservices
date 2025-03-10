package com.example.lab4menuitem;

import com.example.lab4menuitem.entity.DishType;
import com.example.lab4menuitem.entity.MenuItem;
import com.example.lab4menuitem.service.DishTypeService;
import com.example.lab4menuitem.service.MenuItemService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final MenuItemService menuItemService;
    private final DishTypeService dishTypeService;

    @Autowired
    public InitializeData (DishTypeService dishTypeService, MenuItemService menuItemService)
    {
        this.dishTypeService=dishTypeService;
        this.menuItemService=menuItemService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        DishType breakfast = DishType.builder()
                .id(UUID.fromString("6ae31c53-5c3a-41b4-92ff-1ab9c42405f8"))
                .build();
        DishType dessert = DishType.builder()
                .id(UUID.fromString("911128a2-cd28-49b1-93ce-6df720fd73da"))
                .build();
        DishType pasta = DishType.builder()
                .id(UUID.fromString("a80f3d25-c0f8-44e0-ab13-61deb5d48945"))
                .build();

        dishTypeService.save(breakfast);
        dishTypeService.save(dessert);
        dishTypeService.save(pasta);

        MenuItem eggs = MenuItem.builder()
                .name("scrambled eggs")
                .price(19.50)
                .dishType(breakfast)
                .build();
        MenuItem oatmeal = MenuItem.builder()
                .name("oatmeal")
                .price(15)
                .dishType(breakfast)
                .build();
        MenuItem bagel = MenuItem.builder()
                .name("bagel")
                .price(18)
                .dishType(breakfast)
                .build();
        MenuItem pancakes = MenuItem.builder()
                .name("pancakes")
                .price(13.50)
                .dishType(breakfast)
                .build();
        MenuItem cake = MenuItem.builder()
                .name("cheese cake")
                .price(13)
                .dishType(dessert)
                .build();
        MenuItem brownie = MenuItem.builder()
                .name("brownie")
                .price(12)
                .dishType(dessert)
                .build();
        MenuItem iceCream = MenuItem.builder()
                .name("ice cream")
                .price(15)
                .dishType(dessert)
                .build();
        MenuItem pudding = MenuItem.builder()
                .name("pudding")
                .price(16.50)
                .dishType(dessert)
                .build();
        MenuItem lasagne = MenuItem.builder()
                .name("lasagne")
                .price(32)
                .dishType(pasta)
                .build();
        MenuItem spaghetti = MenuItem.builder()
                .name("spaghetti bolognese")
                .price(27)
                .dishType(pasta)
                .build();
        MenuItem carbonara = MenuItem.builder()
                .name("carbonara")
                .price(30)
                .dishType(pasta)
                .build();
        MenuItem ravioli = MenuItem.builder()
                .name("ravioli")
                .price(31)
                .dishType(pasta)
                .build();

        menuItemService.save(eggs);
        menuItemService.save(oatmeal);
        menuItemService.save(bagel);
        menuItemService.save(pancakes);
        menuItemService.save(cake);
        menuItemService.save(brownie);
        menuItemService.save(iceCream);
        menuItemService.save(pudding);
        menuItemService.save(lasagne);
        menuItemService.save(spaghetti);
        menuItemService.save(carbonara);
        menuItemService.save(ravioli);

    }
}

