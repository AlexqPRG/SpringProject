package com.API.shopAPI.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.UUID;

@Entity
public class ItemModel {
    @Id
    @GeneratedValue()
    private UUID id;

    @Size(min = 3, message = "Имя не менее 3 символов")
    private String name;

    @Size(min = 20, message = "Описание не менее 20 символов")
    private String description;

    @DecimalMin(value = "99.99", message = "Минимальная цена не менее 99.99")
    @DecimalMax(value = "99999.99", message = "Максимальная цена не более 99999.99")
    private double price;

    @ManyToMany
    @JoinTable(name = "order_item",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<OrderModel> orders;

    public ItemModel() {

    }

    public ItemModel(UUID id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getName() {
        return name;
    }

    public void setName(@Size(min = 3, message = "Имя не менее 3 символов") String name) {
        this.name = name;
    }

    public @Size(min = 20, message = "Описание не менее 20 символов") String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 20, message = "Описание не менее 20 символов") String description) {
        this.description = description;
    }

    @DecimalMin(value = "99.99", message = "Минимальная цена не менее 99.99")
    @DecimalMax(value = "99999.99", message = "Максимальная цена не более 99999.99")
    public double getPrice() {
        return price;
    }

    public void setPrice(@DecimalMin(value = "99.99", message = "Минимальная цена не менее 99.99") @DecimalMax(value = "99999.99", message = "Максимальная цена не более 99999.99") double price) {
        this.price = price;
    }
}
