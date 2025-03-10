package com.example.lab4menuitem.entity;

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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "dishType", cascade = CascadeType.ALL)
    private List<MenuItem> menuItems;
}
