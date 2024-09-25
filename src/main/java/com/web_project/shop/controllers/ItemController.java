package com.web_project.shop.controllers;

import com.web_project.shop.model.ItemModel;
import com.web_project.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    public ItemService itemService;

    @GetMapping("/all")
    public String getAllItems(Model model){
        model.addAttribute("items", itemService.findAllItems());
        return "itemList";
    }

    @GetMapping("/all/{id}")
    public String getItemById(@PathVariable("id") int id, Model model){
        model.addAttribute("items", itemService.findItemById(id));
        return "itemList";
    }

    @PostMapping("/add")
    public String addItem(@RequestParam String name,
                          @RequestParam String description,
                          @RequestParam double price){
        ItemModel itemModel = new ItemModel(0,name,description,price);
        itemService.addItem(itemModel);
        return "redirect:/items/all";
    }

    @PostMapping("/update")
    public String updateItem(@RequestParam int id,
                             @RequestParam String name,
                             @RequestParam String description,
                             @RequestParam double price){
        ItemModel updateModel = new ItemModel(id, name,description,price);
        itemService.updateItem(updateModel);
        return "redirect:/items/all";
    }

    @PostMapping("/delete")
    public String deleteItem(@RequestParam int id){
        itemService.deleteItem(id);
        return "redirect:/items/all";
    }

}
