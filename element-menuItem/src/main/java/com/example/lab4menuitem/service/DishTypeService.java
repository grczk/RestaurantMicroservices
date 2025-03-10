package com.example.lab4menuitem.service;

import com.example.lab4menuitem.entity.DishType;
import com.example.lab4menuitem.repository.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DishTypeService {
    private final DishTypeRepository repository;

    @Autowired
    public DishTypeService(DishTypeRepository repository) {
        this.repository=repository;
    }
    public Optional<DishType> findById(UUID id) {
        return repository.findById(id);
    }
    public void save(DishType dishType) {
        repository.save(dishType);
    }
    public void save(UUID id) {
        repository.save(DishType.builder().id(id).build());
    }

    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
    public long count() { return repository.count();}
}
