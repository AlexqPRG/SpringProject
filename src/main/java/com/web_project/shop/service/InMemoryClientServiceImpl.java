package com.web_project.shop.service;

import com.web_project.shop.model.ClientModel;
import com.web_project.shop.repository.InMemoryClientRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryClientServiceImpl implements ClientService{

    private final InMemoryClientRepository inMemoryClientRepository;

    public InMemoryClientServiceImpl(InMemoryClientRepository inMemoryClientRepository) {
        this.inMemoryClientRepository = inMemoryClientRepository;
    }

    @Override
    public List<ClientModel> findAllClients() {
        return inMemoryClientRepository.findAllClients();
    }

    @Override
    public ClientModel findClientById(int id) {
        return inMemoryClientRepository.findClientById(id);
    }

    @Override
    public ClientModel addClient(ClientModel clientModel) {
        return inMemoryClientRepository.addClient(clientModel);
    }

    @Override
    public ClientModel updateClient(ClientModel clientModel) {
        return inMemoryClientRepository.updateClient(clientModel);
    }

    @Override
    public void deleteClient(int id) {
        inMemoryClientRepository.deleteClient(id);
    }

    @Override
    public List<ClientModel> findClientsByName(String param, String name) {
        return inMemoryClientRepository.findClientsByName(param,name);
    }

    @Override
    public List<ClientModel> filterClients(String when, String time, String gender) {
        return inMemoryClientRepository.filterClients(when, time, gender);
    }

    @Override
    public void softDeleteClient(int id) {
        inMemoryClientRepository.softDeleteClient(id);
    }

    @Override
    public List<ClientModel> paginClients(int page, int size) {
        return inMemoryClientRepository.paginClients(page, size);
    }

    @Override
    public int getSizePaginClients() {
        return inMemoryClientRepository.getSizePaginClients();
    }

}
