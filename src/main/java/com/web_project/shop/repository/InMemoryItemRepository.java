package com.web_project.shop.repository;

import com.web_project.shop.model.ItemModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryItemRepository {
    private List<ItemModel> items = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public List<ItemModel> findAllItems(){
        return new ArrayList<>(items);
    }

    public ItemModel findItemById(int id){
        return items.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    public ItemModel addItem(ItemModel item){
        item.setId(idCounter.getAndIncrement());
        items.add(item);
        return item;
    }

    public ItemModel updateItem(ItemModel itemModel){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getId() == itemModel.getId()){
                items.set(i, itemModel);
                return itemModel;
            }
        }
        return null;
    }

    public void deleteItem(int id){
        items.removeIf(item -> item.getId() == id);
    }
}
