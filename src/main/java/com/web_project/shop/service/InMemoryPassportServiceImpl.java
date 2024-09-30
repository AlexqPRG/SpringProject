package com.web_project.shop.service;

import com.web_project.shop.model.PassportModel;
import com.web_project.shop.repository.PassportRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryPassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;

    public InMemoryPassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public List<PassportModel> findAllPassports(){
        return passportRepository.findAll(Sort.by("id"));
    }

    @Override
    public PassportModel findPassportById(UUID id){
        return passportRepository.findById(id).orElse(null);
    }

    @Override
    public PassportModel addPassport(PassportModel passport){
        return passportRepository.save(passport);
    }

    @Override
    public PassportModel updatePassport(PassportModel passport){
        if(passportRepository.existsById(passport.getId())){
            return passportRepository.save(passport);
        }
        return null;
    }

    @Override
    public void deletePassport(UUID id){
        if(passportRepository.existsById(id)){
            passportRepository.deleteById(id);
        }
    }
}
