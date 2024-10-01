package com.web_project.shop.service;

import com.web_project.shop.model.AddressModel;
import com.web_project.shop.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InMemoryAddressService extends InMemoryAbstractService<AddressModel, UUID, AddressRepository> {
    private final AddressRepository repository;
    public InMemoryAddressService(AddressRepository jpaRepository, AddressRepository repository) {
        super(jpaRepository);
        this.repository = repository;
    }
}
