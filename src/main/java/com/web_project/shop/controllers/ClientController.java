package com.web_project.shop.controllers;

import com.web_project.shop.model.ClientModel;
import com.web_project.shop.repository.InMemoryClientRepository;
import com.web_project.shop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    public ClientService clientService;

    @GetMapping("/all")
    public String findAllClients(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "5") int size,
                                 Model model) {
        model.addAttribute("clients", clientService.paginClients(page, size));
        model.addAttribute("page", page);
        model.addAttribute("count", clientService.getSizePaginClients());
        return "clientsList";
    }

    @GetMapping("/all/{id}")
    public String findClientById(@PathVariable("id") int id, Model model) {
        model.addAttribute("clients", clientService.findClientById(id));
        model.addAttribute("page", 0);
        model.addAttribute("count", 0);
        return "clientsList";
    }

    @PostMapping("/add")
    public String createClient(@RequestParam String login,
                               @RequestParam String password,
                               @RequestParam String name,
                               @RequestParam String secondName,
                               @RequestParam String patronymic,
                               @RequestParam String email,
                               @RequestParam String number,
                               @RequestParam String gender) {

        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        ClientModel createModel = new ClientModel(0, login, password, name, secondName, patronymic, email, number, gender, currentDate.format(formatter), false);
        clientService.addClient(createModel);

        return "redirect:/clients/all";
    }

    @PostMapping("/update")
    public String updateCreate(@RequestParam int id,
                               @RequestParam String login,
                               @RequestParam String password,
                               @RequestParam String name,
                               @RequestParam String secondName,
                               @RequestParam String patronymic,
                               @RequestParam String email,
                               @RequestParam String number,
                               @RequestParam String gender,
                               @RequestParam String dateCreate) {
        ClientModel updateModel = new ClientModel(id, login, password, name,secondName, patronymic, email, number, gender, dateCreate, false);
        clientService.updateClient(updateModel);
        return "redirect:/clients/all";
    }

    @PostMapping("/delete")
    public String deleteClient(@RequestParam int id){
        clientService.deleteClient(id);
        return "redirect:/clients/all";
    }

   @PostMapping("/search")
    public String findClientsByParam(@RequestParam String param, @RequestParam String value, Model model){
        model.addAttribute("clients", clientService.findClientsByName(param, value));
        return "clientsFilterPage";
   }

   @PostMapping("/filter")
    public String filerClients(@RequestParam String when,
                               @RequestParam String time,
                               @RequestParam String gender, Model model){

        model.addAttribute("clients", clientService.filterClients(when, time, gender));
        return "clientsFilterPage";
   }

   @PostMapping("/softdelete")
   public String softDeleteClient(@RequestParam int id) {
       clientService.softDeleteClient(id);
       return "redirect:/clients/all";
   }


   @PostMapping("/deleteCheckBox")
    public String allDeleteClients(@RequestParam List<Integer> clientIds){
        for(var i : clientIds){
            clientService.softDeleteClient(i);
            System.out.println(i);
        }
       return "redirect:/clients/all";
   }
}
