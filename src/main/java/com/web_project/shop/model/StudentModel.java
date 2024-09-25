package com.web_project.shop.model;

import jakarta.annotation.Nullable;

public class StudentModel {
    private int Id;
    private String Name;
    private String SecondName;
    @Nullable
    private String Patronymic;
    @Nullable
    private String CorpEmail;

    public StudentModel(int id, String name, String secondName, @Nullable String patronymic, @Nullable String corpEmail) {
        Id = id;
        Name = name;
        SecondName = secondName;
        Patronymic = patronymic;
        CorpEmail = corpEmail;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    @Nullable
    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(@Nullable String patronymic) {
        Patronymic = patronymic;
    }

    @Nullable
    public String getCorpEmail() {
        return CorpEmail;
    }

    public void setCorpEmail(@Nullable String corpEmail) {
        CorpEmail = corpEmail;
    }
}
