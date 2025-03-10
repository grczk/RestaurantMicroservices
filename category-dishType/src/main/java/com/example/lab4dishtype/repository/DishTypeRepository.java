package com.example.lab4dishtype.repository;

import com.example.lab4dishtype.entity.DishType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DishTypeRepository extends JpaRepository<DishType, UUID> {
    Optional<DishType> findByName(String name);

}
