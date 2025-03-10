package com.example.lab4menuitem.repository;

import com.example.lab4menuitem.entity.DishType;
import com.example.lab4menuitem.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, UUID> {
    Optional<MenuItem> findByName(String name);
    List<MenuItem> findAllByDishType(DishType dishType);
}
