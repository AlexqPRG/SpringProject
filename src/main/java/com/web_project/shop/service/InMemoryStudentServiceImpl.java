package com.web_project.shop.service;

import com.web_project.shop.model.StudentModel;
import com.web_project.shop.repository.StudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class InMemoryStudentServiceImpl extends InMemoryAbstractService<StudentModel, UUID, StudentRepository> {
    private final StudentRepository studentRepository;

    public InMemoryStudentServiceImpl(StudentRepository jpaRepository, StudentRepository studentRepository) {
        super(jpaRepository);
        this.studentRepository = studentRepository;
    }
}
