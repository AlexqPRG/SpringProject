package com.API.shopAPI.service;

import com.API.shopAPI.model.StudentModel;
import com.API.shopAPI.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InMemoryStudentServiceImpl extends InMemoryAbstractService<StudentModel, UUID, StudentRepository> {
    private final StudentRepository studentRepository;

    public InMemoryStudentServiceImpl(StudentRepository jpaRepository, StudentRepository studentRepository) {
        super(jpaRepository);
        this.studentRepository = studentRepository;
    }
}
