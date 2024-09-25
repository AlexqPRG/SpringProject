package com.web_project.shop.service;

import com.web_project.shop.model.StudentModel;

import java.util.List;

public interface StudentService {
    public List<StudentModel> findAllStudents();

    public StudentModel findStudentById(int id);

    public StudentModel addStudent(StudentModel student);

    public StudentModel updateStudent(StudentModel student);

    public void deleteStudent(int id);
}
