package com.web_project.shop.service;

import com.web_project.shop.model.PassportModel;
import com.web_project.shop.repository.PassportRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryPassportServiceImpl extends InMemoryAbstractService<PassportModel, UUID, PassportRepository> {
    private final PassportRepository passportRepository;


    public InMemoryPassportServiceImpl(PassportRepository jpaRepository, PassportRepository passportRepository) {
        super(jpaRepository);
        this.passportRepository = passportRepository;
    }
}
