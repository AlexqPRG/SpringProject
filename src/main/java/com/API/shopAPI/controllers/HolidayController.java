package com.API.shopAPI.controllers;

import com.API.shopAPI.model.HolidayModel;
import com.API.shopAPI.service.InMemoryHolidayServiceImpl;
import com.API.shopAPI.service.InMemoryHolidayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/holidays")
public class HolidayController {
    @Autowired
    private final InMemoryHolidayServiceImpl holidayService;

    public HolidayController(InMemoryHolidayServiceImpl holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping
    public List<HolidayModel> getAllHolidays(){
        return holidayService.findAll();
    }

    @GetMapping("/{id}")
    public HolidayModel getHolidayById(@PathVariable UUID id){
        return holidayService.findById(id);
    }

    @PostMapping
    public HolidayModel createHoliday(@RequestBody HolidayModel holiday){
        return holidayService.createNote(holiday);
    }

    @PutMapping("/{id}")
    public HolidayModel updateHoliday(@PathVariable UUID id, @RequestBody HolidayModel holiday){
        holiday.setId(id);
        return holidayService.updateNote(holiday, id);
    }

    @DeleteMapping("/{id}")
    public void deleteHoliday(@PathVariable UUID id){
        holidayService.deleteNote(id);
    }
}
