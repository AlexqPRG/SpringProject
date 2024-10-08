package com.API.shopAPI.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "students")
public class StudentModel {
    @Id
    @GeneratedValue
    private UUID Id;
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

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private PassportModel passport;

    @ManyToOne
    @JoinColumn(name = "university_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private UniversityModel university;

    @ManyToMany
    @JoinTable(name = "student_holiday",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "holiday_id"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<HolidayModel> holidays;

    public StudentModel(){}

    public StudentModel(UUID id, String name, String secondName, @Nullable String patronymic, @Nullable String corpEmail, PassportModel passport, UniversityModel university, List<HolidayModel> holidays) {
        Id = id;
        Name = name;
        SecondName = secondName;
        Patronymic = patronymic;
        CorpEmail = corpEmail;
        this.passport = passport;
        this.university = university;
        this.holidays = holidays;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
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

    public PassportModel getPassport() {
        return passport;
    }

    public void setPassport(PassportModel passport) {
        this.passport = passport;
    }

    public UniversityModel getUniversity() {
        return university;
    }

    public void setUniversity(UniversityModel university) {
        this.university = university;
    }

    public List<HolidayModel> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<HolidayModel> holidays) {
        this.holidays = holidays;
    }
}
