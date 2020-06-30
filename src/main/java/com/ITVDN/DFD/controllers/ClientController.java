package com.ITVDN.DFD.controllers;

import com.ITVDN.DFD.entities.Client;
import com.ITVDN.DFD.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/profile")
    public String getClientProfile(Model model) {
        return "clientProfile";
    }

    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client result = clientService.saveClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Client> getClient(@PathVariable long id) {
        Client result = clientService.getClient(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
