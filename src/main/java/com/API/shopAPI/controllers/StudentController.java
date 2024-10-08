package com.API.shopAPI.controllers;

import com.API.shopAPI.model.StudentModel;
import com.API.shopAPI.service.InMemoryStudentServiceImpl;
import com.API.shopAPI.service.InMemoryStudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/students")
public class StudentController {
    @Autowired
    private final InMemoryStudentServiceImpl studentService;

    public StudentController(InMemoryStudentServiceImpl studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<StudentModel> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentModel getStudentById(@PathVariable UUID id){
        return studentService.findById(id);
    }

    @PostMapping
    public StudentModel createStudent(@RequestBody StudentModel student){
        return studentService.createNote(student);
    }

    @PutMapping("/{id}")
    public StudentModel updateStudent(@PathVariable UUID id, @RequestBody StudentModel student){
        student.setId(id);
        return studentService.updateNote(student, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable UUID id){
        studentService.deleteNote(id);
    }
}
