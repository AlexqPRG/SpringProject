package com.API.shopAPI.controllers;

import com.API.shopAPI.model.AddressModel;
import com.API.shopAPI.service.InMemoryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/addresses")
public class AddressController {
    @Autowired
    private final InMemoryAddressService addressService;

    public AddressController(InMemoryAddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressModel> getAllAddresses(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressModel getAddressById(@PathVariable UUID id){
        return addressService.findById(id);
    }

    @PostMapping
    public AddressModel createAddress(@RequestBody AddressModel address){
        return addressService.createNote(address);
    }

    @PutMapping("/{id}")
    public AddressModel updateAddress(@PathVariable UUID id, @RequestBody AddressModel address){
        address.setId(id);
        return addressService.updateNote(address, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable UUID id){
        addressService.deleteNote(id);
    }
}
