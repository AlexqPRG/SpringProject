package com.API.shopAPI.controllers;

import com.API.shopAPI.model.PassportModel;
import com.API.shopAPI.service.InMemoryPassportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/passports")
public class PassportController {
    @Autowired
    private final InMemoryPassportServiceImpl passportService;

    public PassportController(InMemoryPassportServiceImpl passportService) {
        this.passportService = passportService;
    }

    @GetMapping
    public List<PassportModel> getAllPassports(){
        return passportService.findAll();
    }

    @GetMapping("/{id}")
    public PassportModel getPassportById(@PathVariable UUID id){
        return passportService.findById(id);
    }

    @PostMapping
    public PassportModel createPassport(@RequestBody PassportModel passport){
        return passportService.createNote(passport);
    }

    @PutMapping("/{id}")
    public PassportModel updatePassport(@PathVariable UUID id, @RequestBody PassportModel passport){
        passport.setId(id);
        return passportService.updateNote(passport, id);
    }

    @DeleteMapping("/{id}")
    public void deletePassport(@PathVariable UUID id){
        passportService.deleteNote(id);
    }
}
