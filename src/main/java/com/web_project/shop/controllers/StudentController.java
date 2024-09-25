package com.web_project.shop.controllers;

import com.web_project.shop.model.StudentModel;
import com.web_project.shop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.findAllStudents());
        return "studentList";
    }

    @PostMapping("/add")
    public String addStudent(@RequestParam String name,
                             @RequestParam String secondName,
                             @RequestParam String patronymic,
                             @RequestParam String corpEmail) {
        StudentModel newStudent = new StudentModel(0, name, secondName, patronymic, corpEmail);
        studentService.addStudent(newStudent);
        return "redirect:/students/all";

    }

    @PostMapping("/update")
    public String updateStudent(@RequestParam int id,
                                @RequestParam String name,
                                @RequestParam String secondName,
                                @RequestParam String patronymic,
                                @RequestParam String corpEmail) {
        StudentModel updateStudent = new StudentModel(id, name, secondName, patronymic, corpEmail);
        studentService.updateStudent(updateStudent);
        return "redirect:/students/all";

    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam int id){
        studentService.deleteStudent(id);
        return "redirect:/students/all";
    }

    @GetMapping("/all/{id}")
    public String getIdStudent(@PathVariable("id") int id, Model model){
        model.addAttribute("students", studentService.findStudentById(id));
        return "studentList";
    }

}
