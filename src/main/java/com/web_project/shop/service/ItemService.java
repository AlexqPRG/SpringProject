package com.web_project.shop.service;

import com.web_project.shop.model.ItemModel;

import java.util.List;

public interface ItemService {
    public List<ItemModel> findAllItems();

    public ItemModel findItemById(Long id);

    public ItemModel addItem(ItemModel item);

    public ItemModel updateItem(ItemModel itemModel);

    public void deleteItem(Long id);

}
