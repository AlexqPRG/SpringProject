package com.web_project.shop.controllers;

import com.web_project.shop.model.PassportModel;
import com.web_project.shop.model.HolidayModel;
import com.web_project.shop.service.HolidayService;
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
@RequestMapping("/holidays")
public class HolidayController {
    @Autowired
    public HolidayService holidayService;

    @Autowired
    public StudentService studentService;


    @GetMapping("/all")
    public String getAllHolidays(Model model) {
        model.addAttribute("holidays", holidayService.findAllHolidays());
        model.addAttribute("holiday", new HolidayModel());
        model.addAttribute("students", studentService.findAllStudents());
        return "holidayList";
    }

    @PostMapping("/add")
    public String addHoliday(@Valid @ModelAttribute("holiday") HolidayModel holiday, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("holidays", holidayService.findAllHolidays());
            model.addAttribute("students", studentService.findAllStudents());
            return "holidayList";
        }
        holidayService.addHoliday(holiday);
        return "redirect:/holidays/all";

    }

    @PostMapping("/update")
    public String updateHoliday(@Valid @ModelAttribute("holiday") HolidayModel holiday, BindingResult result) {
        holidayService.updateHoliday(holiday);
        return "redirect:/holidays/all";

    }

    @PostMapping("/delete")
    public String deleteHoliday(@RequestParam UUID id){
        holidayService.deleteHoliday(id);
        return "redirect:/holidays/all";
    }

    @GetMapping("/all/{id}")
    public String getIdHoliday(@PathVariable("id") UUID id, Model model){
        model.addAttribute("holidays", holidayService.findHolidayById(id));
        model.addAttribute("holiday", new HolidayModel());
        model.addAttribute("students", studentService.findAllStudents());
        return "holidayList";
    }

}
