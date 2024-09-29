package com.web_project.shop.service;

import com.web_project.shop.model.ClientModel;

import java.util.List;

public interface ClientService {

    public List<ClientModel> findAllClients();

    public ClientModel findClientById(Long id);

    public ClientModel addClient(ClientModel clientModel);

    public ClientModel updateClient(ClientModel clientModel);

    public void deleteClient(Long id);

    public List<ClientModel> findClientsByName(String param, String name);

    public List<ClientModel> filterClients (String when, String time, String gender);

    public void softDeleteClient(Long id);

    public List<ClientModel> paginClients(int page, int size);

    public int getSizePaginClients();
}
