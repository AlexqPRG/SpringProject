package com.API.shopAPI.controllers;

import com.API.shopAPI.model.ClientModel;
import com.API.shopAPI.service.InMemoryClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/clients")
public class ClientController {
    @Autowired
    private final InMemoryClientServiceImpl clientService;

    public ClientController(InMemoryClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientModel> getAllClients(){
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientModel getClientById(@PathVariable UUID id){
        return clientService.findById(id);
    }

    @PostMapping
    public ClientModel createClient(@RequestBody ClientModel client){
        for(var item: client.getOrder()){
            System.out.println(item.getId());
            item.setClient(client);
        }
        return clientService.createNote(client);
    }

    @PutMapping("/{id}")
    public ClientModel updateClient(@PathVariable UUID id, @RequestBody ClientModel client){
        client.setId(id);
        for(var item: client.getOrder()){
            item.setClient(client);
        }
        return clientService.updateNote(client, id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable UUID id){
        clientService.deleteNote(id);
    }
}
