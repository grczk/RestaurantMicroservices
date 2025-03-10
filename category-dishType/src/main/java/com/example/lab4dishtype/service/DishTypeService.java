package com.example.lab4dishtype.service;

import com.example.lab4dishtype.entity.DishType;
import com.example.lab4dishtype.repository.DishTypeRepository;
import com.example.lab4dishtype.repository.DishTypeEventRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DishTypeService {
    private final DishTypeRepository repository;
    private final DishTypeEventRestRepository eventRepository;

    @Autowired
    public DishTypeService(DishTypeRepository repository, DishTypeEventRestRepository eventRepository) {
        this.repository=repository;
        this.eventRepository=eventRepository;
    }
    public List<DishType> findAll() {
        return repository.findAll();
    }
    public Optional<DishType> findByName(String name) {
        return repository.findByName(name);
    }
    public Optional<DishType> findById(UUID id) {
        return repository.findById(id);
    }
    public void save(DishType dishType) {
        repository.save(dishType);
        eventRepository.save(dishType.getId());
    }

    public void create(DishType dishType) {
        repository.save(dishType);
    }

    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }
}
