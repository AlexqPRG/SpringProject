package com.web_project.shop.model;

public class ItemModel {
    private int id;
    private String name;
    private String description;
    private double price;

    private boolean isDel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }

    public ItemModel(int id, String name, String description, double price, boolean isDel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isDel = isDel;
    }
}
