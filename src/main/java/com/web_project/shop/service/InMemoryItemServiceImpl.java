package com.web_project.shop.service;

import com.web_project.shop.model.ItemModel;
import com.web_project.shop.repository.InMemoryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryItemServiceImpl implements ItemService{
    private final InMemoryItemRepository inMemoryItemRepository;

    public InMemoryItemServiceImpl(InMemoryItemRepository inMemoryItemRepository) {
        this.inMemoryItemRepository = inMemoryItemRepository;
    }

    @Override
    public List<ItemModel> findAllItems() {
        return inMemoryItemRepository.findAllItems();
    }

    @Override
    public ItemModel findItemById(int id) {
        return inMemoryItemRepository.findItemById(id);
    }

    @Override
    public ItemModel addItem(ItemModel item) {
        return inMemoryItemRepository.addItem(item);
    }

    @Override
    public ItemModel updateItem(ItemModel itemModel) {
        return inMemoryItemRepository.updateItem(itemModel);
    }

    @Override
    public void deleteItem(int id) {
        inMemoryItemRepository.deleteItem(id);
    }
}
