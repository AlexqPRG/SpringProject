package com.API.shopAPI.service;

import com.API.shopAPI.model.AddressModel;
import com.API.shopAPI.repository.AddressRepository;
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
