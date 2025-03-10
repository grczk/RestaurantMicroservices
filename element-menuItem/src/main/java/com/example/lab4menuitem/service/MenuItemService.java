package com.example.lab4menuitem.service;

import com.example.lab4menuitem.entity.DishType;
import com.example.lab4menuitem.entity.MenuItem;
import com.example.lab4menuitem.repository.DishTypeRepository;
import com.example.lab4menuitem.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MenuItemService {
    private final MenuItemRepository repository;
    private final DishTypeRepository dishTypeRepository;

    @Autowired
    public MenuItemService(MenuItemRepository repository, DishTypeRepository dishTypeRepository)
    {
        this.repository=repository;
        this.dishTypeRepository = dishTypeRepository;
    }

    public Optional<MenuItem> findByName(String name) {
        return repository.findByName(name);
    }
    public Optional<MenuItem> findById(UUID id) {
        return repository.findById(id);
    }
    public List<MenuItem> findAll() {
        return repository.findAll();
    }

    public Optional<List<MenuItem>> findAllByDishType(UUID dishTypeId) {
        return dishTypeRepository.findById(dishTypeId)
                .map(repository::findAllByDishType);
    }

    public void save(MenuItem menuItem)
    {
        repository.save(menuItem);
    }

    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

}
