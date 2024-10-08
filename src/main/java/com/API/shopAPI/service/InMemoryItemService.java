package com.API.shopAPI.service;

import com.API.shopAPI.model.ItemModel;
import com.API.shopAPI.repository.ItemRepository;
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
