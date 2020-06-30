package com.ITVDN.DFD.controllers;

import com.ITVDN.DFD.entities.Courier;
import com.ITVDN.DFD.services.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courier")
public class CourierController {

    @Autowired
    private CourierService courierService;

    @GetMapping("/profile")
    public String getClientProfile() {
        return "courierProfile";
    }


    @PostMapping("/create")
    public ResponseEntity<Courier> createClient(@RequestBody Courier courier) {
        Courier result = courierService.saveCourier(courier);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Courier> getClient(@PathVariable long id) {
        Courier result = courierService.getCourier(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}