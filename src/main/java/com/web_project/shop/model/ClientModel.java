package com.web_project.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class ClientModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 8, max = 25, message = "Логин не менее 8 и не более 25")
    private String login;
    @Size(min = 8, max = 25, message = "Логин не менее 8 и не более 25")
    private String password;

    @Size(min = 5, message = "Имя не менее 5 символов")
    private String name;
    @Size(min = 1, max = 20, message = "Фамилия не более 20 и не менее 1")
    private String secondName;
    @Size(min = 1, max = 20, message = "Отчество не более 20 и не менее 1")
    private String patronymic;

    @Email(message = "Некорректный емейл")
    private String email;

    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "Неверный формат телефона")
    private String number;

    @NotNull(message = "Значение не может быть null")
    private String gender;

    @NotNull
    private String dateCreate;

    @NotNull(message = "Значение не может быть null")
    private boolean isDel;

    public ClientModel() {
    }

    public ClientModel(Long id, String login, String password, String name, String secondName, String patronymic, String email, String number, String gender, String dateCreate, boolean isDel) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Size(min = 8, max = 25, message = "Логин не менее 8 и не более 25") String getLogin() {
        return login;
    }

    public void setLogin(@Size(min = 8, max = 25, message = "Логин не менее 8 и не более 25") String login) {
        this.login = login;
    }

    public @Size(min = 8, max = 25, message = "Логин не менее 8 и не более 25") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 8, max = 25, message = "Логин не менее 8 и не более 25") String password) {
        this.password = password;
    }

    public @Size(min = 5, message = "Имя не менее 5 символов") String getName() {
        return name;
    }

    public void setName(@Size(min = 5, message = "Имя не менее 5 символов") String name) {
        this.name = name;
    }

    public @Size(min = 1, max = 20, message = "Фамилия не более 20 и не менее 1") String getSecondName() {
        return secondName;
    }

    public void setSecondName(@Size(min = 1, max = 20, message = "Фамилия не более 20 и не менее 1") String secondName) {
        this.secondName = secondName;
    }

    public @Size(min = 1, max = 20, message = "Отчество не более 20 и не менее 1") String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(@Size(min = 1, max = 20, message = "Отчество не более 20 и не менее 1") String patronymic) {
        this.patronymic = patronymic;
    }

    public @Email(message = "Некорректный емейл") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Некорректный емейл") String email) {
        this.email = email;
    }

    public @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "Неверный формат телефона") String getNumber() {
        return number;
    }

    public void setNumber(@Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "Неверный формат телефона") String number) {
        this.number = number;
    }

    public @NotNull(message = "Значение не может быть null") String getGender() {
        return gender;
    }

    public void setGender(@NotNull(message = "Значение не может быть null") String gender) {
        this.gender = gender;
    }

    public @NotNull String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(@NotNull String dateCreate) {
        this.dateCreate = dateCreate;
    }

    @NotNull(message = "Значение не может быть null")
    public boolean isDel() {
        return isDel;
    }

    public void setDel(@NotNull(message = "Значение не может быть null") boolean del) {
        isDel = del;
    }
}
