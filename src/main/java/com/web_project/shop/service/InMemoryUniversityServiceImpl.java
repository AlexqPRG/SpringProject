package com.web_project.shop.service;

import com.web_project.shop.model.UniversityModel;
import com.web_project.shop.repository.UniversityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryUniversityServiceImpl implements UniversityService {
    private final UniversityRepository universityRepository;

    public InMemoryUniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public List<UniversityModel> findAllUniversities(){
        return universityRepository.findAll(Sort.by("id"));
    }

    @Override
    public UniversityModel findUniversityById(UUID id){
        return universityRepository.findById(id).orElse(null);
    }

    @Override
    public UniversityModel addUniversity(UniversityModel university){
        return universityRepository.save(university);
    }

    @Override
    public UniversityModel updateUniversity(UniversityModel university){
        if(universityRepository.existsById(university.getId())){
            return universityRepository.save(university);
        }
        return null;
    }

    @Override
    public void deleteUniversity(UUID id){
        if(universityRepository.existsById(id)){
            universityRepository.deleteById(id);
        }
    }
}
