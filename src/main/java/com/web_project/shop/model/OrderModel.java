package com.web_project.shop.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class OrderModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String date;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;

    @ManyToMany
    @JoinTable(name = "order_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<ItemModel> items;

    public OrderModel() {}

    public OrderModel(UUID id, String date, double totalPrice, ClientModel client, List<ItemModel> items) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.client = client;
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

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }
}
