package com.ITVDN.DFD.controllers;

import com.ITVDN.DFD.entities.Restaurant;
import com.ITVDN.DFD.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public String getClientProfile(Model model) {
        return "restaurantPage";
    }

    @PostMapping("/create")
    public ResponseEntity<Restaurant> createAdmin(@RequestBody Restaurant restaurant) {
        Restaurant result = restaurantService.saveRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Restaurant> getAdmin(@PathVariable long id) {
        Restaurant result = restaurantService.getRestaurant(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
