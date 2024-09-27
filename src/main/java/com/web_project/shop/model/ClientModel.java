package com.web_project.shop.model;

import java.time.LocalDate;

public class ClientModel {
    private int id;
    private String login;
    private String password;

    private String name;
    private String secondName;
    private String patronymic;

    private String email;
    private String number;
    private String gender;

    private String dateCreate;

    private boolean isDel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean getDel() {
        return isDel;
    }

    public void setDel(boolean del) {
        isDel = del;
    }

    public ClientModel(int id, String login, String password, String name, String secondName, String patronymic, String email, String number, String gender, String dateCreate, boolean isDel) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.email = email;
        this.number = number;
        this.gender = gender;
        this.dateCreate = dateCreate;
        this.isDel = isDel;
    }
}
