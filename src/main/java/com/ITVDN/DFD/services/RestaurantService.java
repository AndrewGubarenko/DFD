package com.ITVDN.DFD.services;

import com.ITVDN.DFD.entities.Restaurant;
import com.ITVDN.DFD.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public Restaurant getRestaurant(long id) {
        return restaurantRepository.findById(id).get();
    }
}
