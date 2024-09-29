package com.web_project.shop.service;

import com.web_project.shop.model.ItemModel;
import com.web_project.shop.repository.ItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;

    public InMemoryItemServiceImpl(ItemRepository ItemRepository) {
        this.itemRepository = ItemRepository;
    }


    @Override
    public List<ItemModel> findAllItems() {
        return itemRepository.findAll(Sort.by("id"));
//        return findAll(itemRepository);
    }

    @Override
    public ItemModel findItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public ItemModel addItem(ItemModel item) {
        return itemRepository.save(item);
    }

    @Override
    public ItemModel updateItem(ItemModel itemModel) {
        if(itemRepository.existsById(itemModel.getId())){
            return itemRepository.save(itemModel);
        }
        return null;
    }

    @Override
    public void deleteItem(Long id) {
        if(itemRepository.existsById(id)){
            itemRepository.deleteById(id);
        }
    }
}
