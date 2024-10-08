package com.API.shopAPI.service;

import com.API.shopAPI.model.UniversityModel;
import com.API.shopAPI.repository.UniversityRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InMemoryUniversityServiceImpl extends InMemoryAbstractService<UniversityModel, UUID, UniversityRepository> {
    private final UniversityRepository universityRepository;

    public InMemoryUniversityServiceImpl(UniversityRepository jpaRepository, UniversityRepository universityRepository) {
        super(jpaRepository);
        this.universityRepository = universityRepository;
    }
}
