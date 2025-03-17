package com.example.roomservice.controller;

import com.example.roomservice.dto.request.ClientRequest;
import com.example.roomservice.dto.response.ClientResponse;
import com.example.roomservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public String showClientForm(@RequestParam(name = "bookingId") Long bookingId,
                                 Model model){
        model.addAttribute("bookingId", bookingId);
        return "client-form";
    }

    @PostMapping("/create")
    public String createClient(@RequestParam(name = "name") String name,
                               @RequestParam(name = "email") String email,
                               @RequestParam(name = "bookingId") Long bookingId){

        ClientResponse client = clientService.create(new ClientRequest(name, email));

        return "redirect:/bookings/confirmation?bookingId=" + bookingId + "&clientId=" + client.getClientId();
    }


}
