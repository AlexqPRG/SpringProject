package com.web_project.shop.controllers;

import com.web_project.shop.model.AddressModel;
import com.web_project.shop.model.ItemModel;
import com.web_project.shop.model.OrderModel;
import com.web_project.shop.service.InMemoryAddressService;
import com.web_project.shop.service.InMemoryItemService;
import com.web_project.shop.service.InMemoryOrderService;
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
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    public InMemoryAddressService addressService;



    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPLOYEE', 'MANAGER')")
    @GetMapping("/all")
    public String getAllAddresses(Model model) {
        model.addAttribute("addresses", addressService.findAll());
        model.addAttribute("address", new AddressModel());
        return "addressList";
    }

    @PostMapping("/add")
    public String addAddress(@Valid @ModelAttribute("address") AddressModel address, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("addresses", addressService.findAll());
            return "addressList";
        }
        addressService.createNote(address);
        return "redirect:/addresses/all";

    }

    @PostMapping("/update")
    public String updateAddress(@Valid @ModelAttribute("address") AddressModel address, BindingResult result) {
        addressService.updateNote(address, address.getId());
        return "redirect:/addresses/all";

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/delete")
    public String deleteAddress(@RequestParam UUID id){
        addressService.deleteNote(id);
        return "redirect:/addresses/all";
    }

    @GetMapping("/all/{id}")
    public String getIdAddress(@PathVariable("id") UUID id, Model model){
        model.addAttribute("addresses", addressService.findById(id));
        model.addAttribute("address", new AddressModel());
        return "addressList";
    }

}
