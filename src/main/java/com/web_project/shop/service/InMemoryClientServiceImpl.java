package com.web_project.shop.service;

import com.web_project.shop.model.ClientModel;
import com.web_project.shop.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InMemoryClientServiceImpl extends InMemoryAbstractService<ClientModel, UUID, ClientRepository>{

    private final ClientRepository clientRepository;


    public InMemoryClientServiceImpl(ClientRepository clientRepository) {
        super(clientRepository);
        this.clientRepository = clientRepository;
    }

    public ClientModel updateClient(ClientModel model, UUID id) {
        if(clientRepository.existsById(model.getId())){
            return clientRepository.save(model);
        }
        return null;
    }


    public List<ClientModel> findClientsByName(String param, String value) {
        switch (param){
            case "login":
                return clientRepository.findAll().stream().filter(clientModel -> clientModel.getLogin().equals(value) && !clientModel.isDel()).collect(Collectors.toList());
            case "password":
                return clientRepository.findAll().stream().filter(clientModel -> clientModel.getPassword().equals(value) && !clientModel.isDel()).collect(Collectors.toList());
            case "name":
                return clientRepository.findAll().stream().filter(clientModel -> clientModel.getName().equals(value) && !clientModel.isDel()).collect(Collectors.toList());
            case "secondName":
                return clientRepository.findAll().stream().filter(clientModel -> clientModel.getSecondName().equals(value) && !clientModel.isDel()).collect(Collectors.toList());
            case "patronymic":
                return clientRepository.findAll().stream().filter(clientModel -> clientModel.getPatronymic().equals(value) && !clientModel.isDel()).collect(Collectors.toList());
            case "email":
                return clientRepository.findAll().stream().filter(clientModel -> clientModel.getEmail().equals(value) && !clientModel.isDel()).collect(Collectors.toList());
            case "number":
                return clientRepository.findAll().stream().filter(clientModel -> clientModel.getNumber().equals(value) && !clientModel.isDel()).collect(Collectors.toList());
            case "gender":
                return clientRepository.findAll().stream().filter(clientModel -> clientModel.getGender().equals(value) && !clientModel.isDel()).collect(Collectors.toList());
            case "dateCreate":
                return clientRepository.findAll().stream().filter(clientModel -> clientModel.getDateCreate().equals(value) && !clientModel.isDel()).collect(Collectors.toList());

            default:
                return null;
        }
    }

    public List<ClientModel> filterClients(String when, String time, String gender) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(time, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String outputDate = dateTime.format(outputFormatter);

        LocalDate formattedData = !time.isEmpty() ? LocalDate.parse(outputDate,formatter) : null;

        return clientRepository.findAll().stream().filter(clientModel -> {
            boolean isGender = gender.equals("none") || clientModel.getGender().equals(gender);
            if(when.isEmpty() || time.isEmpty()){
                return isGender;
            }else{
                return isGender && when.equals("before") ? LocalDate.parse(clientModel.getDateCreate(),formatter).isBefore(formattedData) :
                        LocalDate.parse(clientModel.getDateCreate(), formatter).isAfter(formattedData);
            }



        }).collect(Collectors.toList());
    }

    public void softDeleteClient(UUID id) {
        ClientModel tempClient = clientRepository.findById(id).orElse(null);
        tempClient.setDel(true);
        clientRepository.save(tempClient);
    }

    public List<ClientModel> paginClients(int page, int size) {
        int start = page * size;


        if(start >= clientRepository.findAll().stream().filter(clientModel -> !clientModel.isDel()).toList().size()){
            return new ArrayList<>();
        }

        int end = Math.min(start + size, clientRepository.findAll().stream().filter(clientModel -> !clientModel.isDel()).toList().size());
        return clientRepository.findAll().stream().filter(clientModel -> !clientModel.isDel()).toList().subList(start, end);
    }


    public int getSizePaginClients() {
        return clientRepository.findAll().stream().filter(clientModel -> !clientModel.isDel()).toList().size();
    }
}
