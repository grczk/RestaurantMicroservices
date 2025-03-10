package com.example.lab4menuitem.repository;

import com.example.lab4menuitem.entity.DishType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DishTypeRepository extends JpaRepository<DishType, UUID> {

}
