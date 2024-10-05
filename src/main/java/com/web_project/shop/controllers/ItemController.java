package com.web_project.shop.controllers;

import com.web_project.shop.model.ItemModel;
import com.web_project.shop.service.InMemoryItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    public InMemoryItemService itemServiceTEst;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPLOYEE', 'MANAGER', 'USER')")
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


    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPLOYEE', 'MANAGER', 'USER')")
    @GetMapping("/all/{id}")
    public String getItemById(@PathVariable("id") UUID id, Model model){
        model.addAttribute("items", itemServiceTEst.findById(id));
        model.addAttribute("item", new ItemModel());
        return "itemList";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPLOYEE', 'MANAGER')")
    @PostMapping("/add")
    public String addItem(@Valid @ModelAttribute("item") ItemModel itemModel, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("items", itemServiceTEst.findAll());
            return "itemList";
        }
        itemServiceTEst.createNote(itemModel);
        return "redirect:/items/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPLOYEE', 'MANAGER')")
    @PostMapping("/update")
    public String updateItem(@Valid @ModelAttribute("item") ItemModel itemModel, BindingResult result){
        itemServiceTEst.updateNote(itemModel, itemModel.getId());
        return "redirect:/items/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPLOYEE', 'MANAGER')")
    @PostMapping("/delete")
    public String deleteItem(@RequestParam UUID id){
        itemServiceTEst.deleteNote(id);
        return "redirect:/items/all";
    }

}
