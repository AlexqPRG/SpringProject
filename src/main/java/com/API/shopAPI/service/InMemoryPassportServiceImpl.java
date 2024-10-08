package com.API.shopAPI.service;

import com.API.shopAPI.model.PassportModel;
import com.API.shopAPI.repository.PassportRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InMemoryPassportServiceImpl extends InMemoryAbstractService<PassportModel, UUID, PassportRepository> {
    private final PassportRepository passportRepository;


    public InMemoryPassportServiceImpl(PassportRepository jpaRepository, PassportRepository passportRepository) {
        super(jpaRepository);
        this.passportRepository = passportRepository;
    }
}
