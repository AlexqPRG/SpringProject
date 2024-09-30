package com.web_project.shop.controllers;

import com.web_project.shop.model.PassportModel;
import com.web_project.shop.model.StudentModel;
import com.web_project.shop.repository.StudentRepository;
import com.web_project.shop.service.StudentService;
import com.web_project.shop.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @Autowired
    public UniversityService universityService;


    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.findAllStudents());
        model.addAttribute("student", new StudentModel());
        model.addAttribute("universities", universityService.findAllUniversities());
        return "studentList";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") StudentModel student, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("students", studentService.findAllStudents());
            model.addAttribute("universities", universityService.findAllUniversities());
            return "studentList";
        }
        PassportModel passport = student.getPassport();
        student.setPassport(passport);
        studentService.addStudent(student);
        return "redirect:/students/all";

    }

    @PostMapping("/update")
    public String updateStudent(@Valid @ModelAttribute("student") StudentModel student, BindingResult result) {
        studentService.updateStudent(student);
        return "redirect:/students/all";

    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam UUID id){
        studentService.deleteStudent(id);
        return "redirect:/students/all";
    }

    @GetMapping("/all/{id}")
    public String getIdStudent(@PathVariable("id") UUID id, Model model){
        model.addAttribute("students", studentService.findStudentById(id));
        model.addAttribute("student", new StudentModel());
        model.addAttribute("universities", universityService.findAllUniversities());
        return "studentList";
    }

}
