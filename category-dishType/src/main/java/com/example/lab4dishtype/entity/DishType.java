package com.example.lab4dishtype.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dish_types")
public class DishType {
    @Id
    private UUID id;
    @Column(name = "dish_name")
    private String name;
    @Column(name = "dish_number")
    private int number;
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToMany(mappedBy = "dishType", cascade = CascadeType.ALL)
//    private List<MenuItem> menuItems;
}
