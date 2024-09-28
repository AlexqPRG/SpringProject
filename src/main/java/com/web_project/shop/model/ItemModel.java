package com.web_project.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "Имя не менее 3 символов")
    private String name;

    @Size(min = 20, message = "Описание не менее 20 символов")
    private String description;

    @DecimalMin(value = "99.99", message = "Минимальная цена не менее 99.99")
    @DecimalMax(value = "99999.99", message = "Максимальная цена не более 99999.99")
    private double price;

    public ItemModel() {

    }

    public ItemModel(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getName() {
        return name;
    }

    public void setName(@Size(min = 3, message = "Имя не менее 3 символов") String name) {
        this.name = name;
    }

    public @Size(min = 3) String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 3) String description) {
        this.description = description;
    }

    @DecimalMax(value = "99999.99")
    public double getPrice() {
        return price;
    }

    public void setPrice(@DecimalMax(value = "99999.99") double price) {
        this.price = price;
    }
}
