package com.API.shopAPI.controllers;

import com.API.shopAPI.DTO.OrderDTO;
import com.API.shopAPI.model.ClientModel;
import com.API.shopAPI.model.OrderModel;
import com.API.shopAPI.service.InMemoryClientServiceImpl;
import com.API.shopAPI.service.InMemoryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/orders")
public class OrderController {
    @Autowired
    private final InMemoryOrderService orderService;

    @Autowired
    private final InMemoryClientServiceImpl clientService;

    public OrderController(InMemoryOrderService orderService, InMemoryClientServiceImpl clientService) {
        this.orderService = orderService;
        this.clientService = clientService;
    }

    @GetMapping
    public List<OrderDTO> getAllOrders(){
        List<OrderModel> orders = orderService.findAll();
        return orders.stream().map(OrderDTO::new).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public OrderModel getOrderById(@PathVariable UUID id){
        return orderService.findById(id);
    }

    @PostMapping
    public OrderModel createOrder(@RequestBody OrderModel order){
        return orderService.createNote(order);
    }

    @PutMapping("/{id}")
    public OrderModel updateOrder(@PathVariable UUID id, @RequestBody OrderDTO order){
        ClientModel clientModel = clientService.findById(order.getClient_id());
        OrderModel orderModel = order.convertToOrder(clientModel);
        return orderService.updateNote(orderModel, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable UUID id){
        orderService.deleteNote(id);
    }
}
