package com.web_project.shop.controllers;

import com.web_project.shop.model.HolidayModel;
import com.web_project.shop.service.InMemoryHolidayServiceImpl;
import com.web_project.shop.service.InMemoryStudentServiceImpl;
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
    public InMemoryHolidayServiceImpl holidayService;

    @Autowired
    public InMemoryStudentServiceImpl studentService;


    @GetMapping("/all")
    public String getAllHolidays(Model model) {
        model.addAttribute("holidays", holidayService.findAll());
        model.addAttribute("holiday", new HolidayModel());
        model.addAttribute("students", studentService.findAll());
        return "holidayList";
    }

    @PostMapping("/add")
    public String addHoliday(@Valid @ModelAttribute("holiday") HolidayModel holiday, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("holidays", holidayService.findAll());
            model.addAttribute("students", studentService.findAll());
            return "holidayList";
        }
        holidayService.createNote(holiday);
        return "redirect:/holidays/all";

    }

    @PostMapping("/update")
    public String updateHoliday(@Valid @ModelAttribute("holiday") HolidayModel holiday, BindingResult result) {
        holidayService.updateNote(holiday, holiday.getId());
        return "redirect:/holidays/all";

    }

    @PostMapping("/delete")
    public String deleteHoliday(@RequestParam UUID id){
        holidayService.deleteNote(id);
        return "redirect:/holidays/all";
    }

    @GetMapping("/all/{id}")
    public String getIdHoliday(@PathVariable("id") UUID id, Model model){
        model.addAttribute("holidays", holidayService.findById(id));
        model.addAttribute("holiday", new HolidayModel());
        model.addAttribute("students", studentService.findAll());
        return "holidayList";
    }

}
