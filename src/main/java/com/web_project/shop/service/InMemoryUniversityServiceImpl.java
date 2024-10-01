package com.web_project.shop.service;

import com.web_project.shop.model.UniversityModel;
import com.web_project.shop.repository.UniversityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryUniversityServiceImpl extends InMemoryAbstractService<UniversityModel, UUID, UniversityRepository> {
    private final UniversityRepository universityRepository;

    public InMemoryUniversityServiceImpl(UniversityRepository jpaRepository, UniversityRepository universityRepository) {
        super(jpaRepository);
        this.universityRepository = universityRepository;
    }
}
