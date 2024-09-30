package com.web_project.shop.controllers;

import com.web_project.shop.model.PassportModel;
import com.web_project.shop.model.UniversityModel;
import com.web_project.shop.service.UniversityService;
import com.web_project.shop.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/universities")
public class UniversityController {
    @Autowired
    public UniversityService universityService;


    @GetMapping("/all")
    public String getAllUniversities(Model model) {
        model.addAttribute("universities", universityService.findAllUniversities());
        model.addAttribute("university", new UniversityModel());
        return "universityList";
    }

    @PostMapping("/add")
    public String addUniversity(@Valid @ModelAttribute("university") UniversityModel university, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("universities", universityService.findAllUniversities());
            return "universityList";
        }
        universityService.addUniversity(university);
        return "redirect:/universities/all";

    }

    @PostMapping("/update")
    public String updateUniversity(@Valid @ModelAttribute("university") UniversityModel university, BindingResult result) {
        universityService.updateUniversity(university);
        return "redirect:/universities/all";

    }

    @PostMapping("/delete")
    public String deleteUniversity(@RequestParam UUID id){
        universityService.deleteUniversity(id);
        return "redirect:/universities/all";
    }

    @GetMapping("/all/{id}")
    public String getIdUniversity(@PathVariable("id") UUID id, Model model){
        model.addAttribute("universities", universityService.findAllUniversities());
        model.addAttribute("university", new UniversityModel());
        return "universityList";
    }

}
