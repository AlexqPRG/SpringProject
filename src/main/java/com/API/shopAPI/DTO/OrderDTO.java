package com.API.shopAPI.DTO;

import com.API.shopAPI.model.ClientModel;
import com.API.shopAPI.model.ItemModel;
import com.API.shopAPI.model.OrderModel;
import com.API.shopAPI.repository.ClientRepository;
import com.API.shopAPI.service.InMemoryClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class OrderDTO {
    private UUID id;
    private String date;
    private double totalPrice;
    private UUID client_id;
    private List<ItemModel> items;

    public OrderDTO(){}
    public OrderDTO(OrderModel orderModel) {
        this.id = orderModel.getId();
        this.date = orderModel.getDate();
        this.totalPrice = orderModel.getTotalPrice();
        this.client_id = orderModel.getClient() != null ? orderModel.getClient().getId() : null;
        this.items = orderModel.getItems();
    }

    public OrderModel convertToOrder(ClientModel clientModel){
        OrderModel orderModel = new OrderModel();
        orderModel.setId(this.id);
        orderModel.setDate(this.date);
        orderModel.setTotalPrice(this.totalPrice);
        orderModel.setClient(clientModel);
        orderModel.setItems(this.items);
        return orderModel;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public UUID getClient_id() {
        return client_id;
    }

    public void setClient_id(UUID client_id) {
        this.client_id = client_id;
    }
}
