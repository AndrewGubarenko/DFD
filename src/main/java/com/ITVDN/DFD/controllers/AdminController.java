package com.ITVDN.DFD.controllers;

import com.ITVDN.DFD.entities.Administrator;
import com.ITVDN.DFD.entities.Client;
import com.ITVDN.DFD.entities.Courier;
import com.ITVDN.DFD.entities.Restaurant;
import com.ITVDN.DFD.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/main")
    public String getClientProfile(Model model) {
        return "adminPage";
    }

    @PostMapping("/create")
    public ResponseEntity<Administrator> createAdmin(@RequestBody Administrator courier) {
        Administrator result = adminService.saveAdmin(courier);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Administrator> getAdmin(@PathVariable long id) {
        Administrator result = adminService.getAdmin(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/getAllClients")
    public ResponseEntity<Set<Client>> getAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.getAllClients());
    }

    @GetMapping("/getAllCouriers")
    public ResponseEntity<Set<Courier>> getAllCouriers() {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.getAllCouriers());
    }

    @GetMapping("/getAllRestaurants")
    public ResponseEntity<Set<Restaurant>> getAllRestaurants() {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.getAllRestaurants());
    }
}
