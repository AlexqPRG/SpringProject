package com.web_project.shop.service;

import com.web_project.shop.model.StudentModel;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    public List<StudentModel> findAllStudents();

    public StudentModel findStudentById(UUID id);

    public StudentModel addStudent(StudentModel student);

    public StudentModel updateStudent(StudentModel student);

    public void deleteStudent(UUID id);
}
