package com.web_project.shop.repository;

import com.web_project.shop.model.ClientModel;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryClientRepository {
    private List<ClientModel> clients = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public List<ClientModel> findAllClients(){
        return clients.stream().filter(clientModel -> !clientModel.getDel()).collect(Collectors.toList());
    }

    public ClientModel findClientById(int id){
        return clients.stream().filter(client -> client.getId() == id).findFirst().orElse(null);
    }

    public ClientModel addClient(ClientModel clientModel){
        clientModel.setId(idCounter.getAndIncrement());
        clients.add(clientModel);
        return clientModel;
    }

    public ClientModel updateClient(ClientModel clientModel){
        for (int i = 0; i < clients.size(); i++){
            if(clients.get(i).getId() == clientModel.getId()){
                clients.set(i, clientModel);
                return clientModel;
            }
        }
        return  null;
    }

    public void deleteClient(int id){
        clients.removeIf(clientModel -> clientModel.getId() == id);
    }


    public List<ClientModel> findClientsByName(String param, String value){
        switch (param){
            case "login":
                return clients.stream().filter(clientModel -> clientModel.getLogin().equals(value) && !clientModel.getDel()).collect(Collectors.toList());
            case "password":
                return clients.stream().filter(clientModel -> clientModel.getPassword().equals(value) && !clientModel.getDel()).collect(Collectors.toList());
            case "name":
                return clients.stream().filter(clientModel -> clientModel.getName().equals(value) && !clientModel.getDel()).collect(Collectors.toList());
            case "secondName":
                return clients.stream().filter(clientModel -> clientModel.getSecondName().equals(value) && !clientModel.getDel()).collect(Collectors.toList());
            case "patronymic":
                return clients.stream().filter(clientModel -> clientModel.getPatronymic().equals(value) && !clientModel.getDel()).collect(Collectors.toList());
            case "email":
                return clients.stream().filter(clientModel -> clientModel.getEmail().equals(value) && !clientModel.getDel()).collect(Collectors.toList());
            case "number":
                return clients.stream().filter(clientModel -> clientModel.getNumber().equals(value) && !clientModel.getDel()).collect(Collectors.toList());
            case "gender":
                return clients.stream().filter(clientModel -> clientModel.getGender().equals(value) && !clientModel.getDel()).collect(Collectors.toList());
            case "dateCreate":
                return clients.stream().filter(clientModel -> clientModel.getDateCreate().equals(value) && !clientModel.getDel()).collect(Collectors.toList());
            default:
                return null;
        }
    }

    public List<ClientModel> filterClients(String when, String time, String gender){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate formattedData = !time.isEmpty() ? LocalDate.parse(time,formatter) : null;
        return findAllClients().stream().filter(clientModel -> {
            boolean isGender = gender.equals("none") || clientModel.getGender().equals(gender);
            if(when.isEmpty() || time.isEmpty()){
                return isGender;
            }else{
               return isGender && when.equals("before") ? LocalDate.parse(clientModel.getDateCreate(),formatter).isBefore(formattedData) :
                       LocalDate.parse(clientModel.getDateCreate(), formatter).isAfter(formattedData);
            }



        }).collect(Collectors.toList());
    }


    public void softDeleteClient(int id){
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getId() == id){
                clients.get(i).setDel(true);
                break;
            }
        }
    }

    public List<ClientModel> paginClients(int page, int size){
        int start = page * size;


        if(start >= findAllClients().size()){
            return new ArrayList<>();
        }

        int end = Math.min(start + size, findAllClients().size());
        return findAllClients().subList(start, end);
    }

    public int getSizePaginClients(){
        return findAllClients().size();
    }
}
