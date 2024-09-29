package com.web_project.shop.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String Name;
    @Size(min = 3, message = "Фамилия не менее 3 символов")
    private String SecondName;
    @Nullable
    @Size(max = 25, message = "Отчество не более 25 символов")
    private String Patronymic;
    @Nullable
    @Email(message = "Емейл не корректен")
    private String CorpEmail;

    public StudentModel(){}

    public StudentModel(Long id, String name, String secondName, @Nullable String patronymic, @Nullable String corpEmail) {
        Id = id;
        Name = name;
        SecondName = secondName;
        Patronymic = patronymic;
        CorpEmail = corpEmail;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getName() {
        return Name;
    }

    public void setName(@Size(min = 3, message = "Имя не менее 3 символов") String name) {
        Name = name;
    }

    public @Size(min = 3, message = "Фамилия не менее 3 символов") String getSecondName() {
        return SecondName;
    }

    public void setSecondName(@Size(min = 3, message = "Фамилия не менее 3 символов") String secondName) {
        SecondName = secondName;
    }

    @Nullable
    public @Size(max = 25, message = "Отчество не более 25 символов") String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(@Nullable @Size(max = 25, message = "Отчество не более 25 символов") String patronymic) {
        Patronymic = patronymic;
    }

    @Nullable
    public @Email(message = "Емейл не корректен") String getCorpEmail() {
        return CorpEmail;
    }

    public void setCorpEmail(@Nullable @Email(message = "Емейл не корректен") String corpEmail) {
        CorpEmail = corpEmail;
    }
}
