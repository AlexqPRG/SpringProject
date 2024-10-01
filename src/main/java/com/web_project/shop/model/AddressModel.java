package com.web_project.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.UUID;

@Entity
public class AddressModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String country;
    private String city;
    private String street;
    private int floor;
    private String numberHouse;

    @OneToOne(optional = false, mappedBy = "address")
    private ClientModel client;

    public AddressModel() {}

    public AddressModel(UUID id, String country, String city, String street, int floor, String numberHouse, ClientModel client) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.floor = floor;
        this.numberHouse = numberHouse;
        this.client = client;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(String numberHouse) {
        this.numberHouse = numberHouse;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }
}
