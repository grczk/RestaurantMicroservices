package com.example.lab4menuitem.entity;

import com.example.lab4menuitem.entity.DishType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu_items")
public class MenuItem {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "item_name")
    private String name;
    @Column(name = "item_price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "dish_type")
    private DishType dishType;
}
