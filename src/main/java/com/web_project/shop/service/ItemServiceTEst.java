package com.web_project.shop.service;

import com.web_project.shop.model.ItemModel;
import com.web_project.shop.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceTEst extends InMemoryAbstractService<ItemModel, Long, ItemRepository> {
    public ItemServiceTEst(ItemRepository jpaRepository) {
        super(jpaRepository);
    }
}
