package com.web_project.shop.service;

import com.web_project.shop.model.ClientModel;
import com.web_project.shop.repository.ClientRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InMemoryClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    public InMemoryClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientModel> findAllClients() {
        return clientRepository.findAll(Sort.by("id")).stream().filter(clientModel -> !clientModel.isDel()).collect(Collectors.toList());
    }

    @Override
    public ClientModel findClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public ClientModel addClient(ClientModel clientModel) {
        return clientRepository.save(clientModel);
    }

    @Override
    public ClientModel updateClient(ClientModel clientModel) {

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(clientModel.getDateCreate(), inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedData = date.format(outputFormatter);

        clientModel.setDateCreate(formattedData);


        if(clientRepository.existsById(clientModel.getId())){
            return clientRepository.save(clientModel);
        }
        return null;
    }

    @Override
    public void deleteClient(Long id) {
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
        }
    }

    @Override
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

    @Override
    public List<ClientModel> filterClients(String when, String time, String gender) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(time, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String outputDate = dateTime.format(outputFormatter);

        LocalDate formattedData = !time.isEmpty() ? LocalDate.parse(outputDate,formatter) : null;

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

    @Override
    public void softDeleteClient(Long id) {
        ClientModel tempClient = clientRepository.findById(id).orElse(null);
        tempClient.setDel(true);
        clientRepository.save(tempClient);
    }

    @Override
    public List<ClientModel> paginClients(int page, int size) {
        int start = page * size;


        if(start >= findAllClients().size()){
            return new ArrayList<>();
        }

        int end = Math.min(start + size, findAllClients().size());
        return findAllClients().subList(start, end);
    }

    @Override
    public int getSizePaginClients() {
        return findAllClients().size();
    }

}
