package com.web_project.shop.service;

import com.web_project.shop.model.ItemModel;
import com.web_project.shop.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InMemoryItemService extends InMemoryAbstractService<ItemModel, UUID, ItemRepository> {
    private ItemRepository repository;
    public InMemoryItemService(ItemRepository jpaRepository) {
        super(jpaRepository);
        this.repository = jpaRepository;
    }
}
