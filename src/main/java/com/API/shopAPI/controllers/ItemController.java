package com.API.shopAPI.controllers;

import com.API.shopAPI.model.ItemModel;
import com.API.shopAPI.service.InMemoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/items")
public class ItemController {
    @Autowired
    private final InMemoryItemService itemService;

    public ItemController(InMemoryItemService itemService) {
        this.itemService = itemService;
    }


    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping
    public List<ItemModel> getAllItems(){
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ItemModel getItemById(@PathVariable UUID id){
        return itemService.findById(id);
    }

    @PostMapping
    public ItemModel createItem(@RequestBody ItemModel item){
        return itemService.createNote(item);
    }

    @PutMapping("/{id}")
    public ItemModel updateItem(@PathVariable UUID id, @RequestBody ItemModel item){
        item.setId(id);
        return itemService.updateNote(item, id);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable UUID id){
        itemService.deleteNote(id);
    }
}
