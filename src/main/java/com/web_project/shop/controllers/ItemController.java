package com.web_project.shop.controllers;

import com.web_project.shop.model.ItemModel;
import com.web_project.shop.repository.ItemRepository;
import com.web_project.shop.service.AbstractService;
import com.web_project.shop.service.ItemService;
import com.web_project.shop.service.ItemServiceTEst;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    public ItemService itemService;

    @Autowired
    public ItemServiceTEst itemServiceTEst;


    @GetMapping("/all")
    public String getAllItems(Model model){
        model.addAttribute("items", itemServiceTEst.findAll());
        model.addAttribute("item", new ItemModel());
        return "itemList";
    }

    @GetMapping("all/test")
    public String getAllTestItems(){
        List<ItemModel> list = itemServiceTEst.findAll();
        for(var item: list){
            System.out.println(item.getId());
        }
        return "itemList";
    }


    @GetMapping("/all/{id}")
    public String getItemById(@PathVariable("id") Long id, Model model){
        model.addAttribute("items", itemServiceTEst.findById(id));
        model.addAttribute("item", new ItemModel());
        return "itemList";
    }

    @PostMapping("/add")
    public String addItem(@Valid @ModelAttribute("item") ItemModel itemModel, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("items", itemServiceTEst.findAll());
            return "itemList";
        }
        itemServiceTEst.createNote(itemModel);
        return "redirect:/items/all";
    }

    @PostMapping("/update")
    public String updateItem(@Valid @ModelAttribute("item") ItemModel itemModel, BindingResult result){
        itemServiceTEst.updateNote(itemModel, itemModel.getId());
        return "redirect:/items/all";
    }

    @PostMapping("/delete")
    public String deleteItem(@RequestParam Long id){
        itemServiceTEst.deleteNote(id);
        return "redirect:/items/all";
    }

}
