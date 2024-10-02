package com.web_project.shop.controllers;

import com.web_project.shop.model.AddressModel;
import com.web_project.shop.model.ClientModel;
import com.web_project.shop.model.ItemModel;
import com.web_project.shop.model.OrderModel;
import com.web_project.shop.service.InMemoryAddressService;
import com.web_project.shop.service.InMemoryClientServiceImpl;
import com.web_project.shop.service.InMemoryOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    public InMemoryClientServiceImpl clientService;

    @Autowired
    public InMemoryAddressService addressService;

    @Autowired
    public InMemoryOrderService orderService;

    @GetMapping("/all")
    public String findAllClients(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "5") int size,
                                 Model model) {
        model.addAttribute("clients", clientService.paginClients(page, size));
        model.addAttribute("page", page);
        model.addAttribute("count", clientService.getSizePaginClients());
        model.addAttribute("client", new ClientModel());
        model.addAttribute("orders", orderService.findAll());
        return "clientsList";
    }

    @GetMapping("address")
    public void fifnwf(){
        AddressModel addressModel = new AddressModel();
        addressService.createNote(addressModel);
    }

    @GetMapping("/all/{id}")
    public String findClientById(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("clients", clientService.findById(id));
        model.addAttribute("page", 0);
        model.addAttribute("count", 0);
        model.addAttribute("client", new ClientModel());
        return "clientsList";
    }

    @PostMapping("/add")
    public String createClient(@Valid @ModelAttribute("client") ClientModel clientModel, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("clients", clientService.paginClients(0, 0));
            model.addAttribute("page", 0);
            model.addAttribute("count", clientService.getSizePaginClients());
            return "clientsList";
        }
        clientService.createNote(clientModel);
        return "redirect:/clients/all";
    }

    @PostMapping("/update")
    public String updateCreate(@Valid @ModelAttribute("client") ClientModel clientModel, @RequestParam("client.order") List<OrderModel> orderList, BindingResult result) {
        clientModel.setOrder(orderList);
        clientService.updateClient(clientModel, clientModel.getId());
        return "redirect:/clients/all";
    }

    @PostMapping("/delete")
    public String deleteClient(@RequestParam UUID id){
        clientService.deleteNote(id);
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
   public String softDeleteClient(@RequestParam UUID id) {
       clientService.softDeleteClient(id);
       return "redirect:/clients/all";
   }


   @PostMapping("/deleteCheckBox")
    public String allDeleteClients(@RequestParam List<UUID> clientIds){
        for(var i : clientIds){
            clientService.softDeleteClient(i);
            System.out.println(i);
        }
       return "redirect:/clients/all";
   }
}
