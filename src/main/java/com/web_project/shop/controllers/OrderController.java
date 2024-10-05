package com.web_project.shop.controllers;

import com.web_project.shop.model.ItemModel;
import com.web_project.shop.model.PassportModel;
import com.web_project.shop.model.OrderModel;
import com.web_project.shop.service.InMemoryClientServiceImpl;
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
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    public InMemoryOrderService orderService;

    @Autowired
    public InMemoryItemService itemService;


    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPLOYEE', 'MANAGER')")
    @GetMapping("/all")
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        model.addAttribute("order", new OrderModel());
        model.addAttribute("items", itemService.findAll());
        return "orderList";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/add")
    public String addOrder(@Valid @ModelAttribute("order") OrderModel order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("orders", orderService.findAll());
            model.addAttribute("items", itemService.findAll());
            return "orderList";
        }
        orderService.createNote(order);
        return "redirect:/orders/all";

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/update")
    public String updateOrder(@Valid @ModelAttribute("order") OrderModel order, @RequestParam("order.items") List<ItemModel> itemList, BindingResult result) {
        order.setItems(itemList);
        orderService.updateNote(order, order.getId());
        return "redirect:/orders/all";

    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    @PostMapping("/delete")
    public String deleteOrder(@RequestParam UUID id) {
        orderService.deleteNote(id);
        return "redirect:/orders/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPLOYEE', 'MANAGER', 'USER')")
    @GetMapping("/all/{id}")
    public String getIdOrder(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("orders", orderService.findById(id));
        model.addAttribute("order", new OrderModel());
        model.addAttribute("items", itemService.findAll());
        return "orderList";
    }
}
