package com.web_project.shop.controllers;

import com.web_project.shop.model.ItemModel;
import com.web_project.shop.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    public ItemService itemService;

    @GetMapping("/all")
    public String getAllItems(Model model){
        model.addAttribute("items", itemService.findAllItems());
        model.addAttribute("item", new ItemModel());
        return "itemList";
    }

    @GetMapping("/all/{id}")
    public String getItemById(@PathVariable("id") Long id, Model model){
        model.addAttribute("items", itemService.findItemById(id));
        model.addAttribute("item", new ItemModel());
        return "itemList";
    }

    @PostMapping("/add")
    public String addItem(@Valid @ModelAttribute("item") ItemModel itemModel, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("items", itemService.findAllItems());
            return "itemList";
        }
        itemService.addItem(itemModel);
        return "redirect:/items/all";
    }

    @PostMapping("/update")
    public String updateItem(@Valid @ModelAttribute("item") ItemModel itemModel, BindingResult result){
        itemService.updateItem(itemModel);
        return "redirect:/items/all";
    }

    @PostMapping("/delete")
    public String deleteItem(@RequestParam Long id){
        itemService.deleteItem(id);
        return "redirect:/items/all";
    }

}
