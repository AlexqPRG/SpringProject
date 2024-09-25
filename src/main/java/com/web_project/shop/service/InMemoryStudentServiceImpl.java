package com.web_project.shop.service;

import com.web_project.shop.model.StudentModel;
import com.web_project.shop.repository.InMemoryStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryStudentServiceImpl implements StudentService {
    private final InMemoryStudentRepository studentRepository;

    public InMemoryStudentServiceImpl(InMemoryStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> findAllStudents(){
        return studentRepository.findAllStudents();
    }

    @Override
    public StudentModel findStudentById(int id){
        return studentRepository.findStudentById(id);
    }

    @Override
    public StudentModel addStudent(StudentModel student){
        return studentRepository.addStudent(student);
    }

    @Override
    public StudentModel updateStudent(StudentModel student){
        return studentRepository.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id){
        studentRepository.deleteStudent(id);
    }
}
