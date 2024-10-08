package com.API.shopAPI.controllers;

import com.API.shopAPI.model.UniversityModel;
import com.API.shopAPI.service.InMemoryUniversityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/universities")
public class UniversityApiController {
    @Autowired
    private final InMemoryUniversityServiceImpl universityService;

    public UniversityApiController(InMemoryUniversityServiceImpl universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<UniversityModel> getAllUniversities(){
        return universityService.findAll();
    }

    @GetMapping("/{id}")
    public UniversityModel getUniversityById(@PathVariable UUID id){
        return universityService.findById(id);
    }

    @PostMapping
    public UniversityModel createUniversity(@RequestBody UniversityModel university){
        return universityService.createNote(university);
    }

    @PutMapping("/{id}")
    public UniversityModel updateUniversity(@PathVariable UUID id, @RequestBody UniversityModel university){
        university.setId(id);
        return universityService.updateNote(university, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversity(@PathVariable UUID id){
        universityService.deleteNote(id);
    }
}
