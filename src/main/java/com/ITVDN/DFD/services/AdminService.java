package com.ITVDN.DFD.services;

import com.ITVDN.DFD.entities.Administrator;
import com.ITVDN.DFD.entities.Client;
import com.ITVDN.DFD.entities.Courier;
import com.ITVDN.DFD.entities.Restaurant;
import com.ITVDN.DFD.repositories.AdminRepository;
import com.ITVDN.DFD.repositories.ClientRepository;
import com.ITVDN.DFD.repositories.CourierRepository;
import com.ITVDN.DFD.repositories.RestaurantRepository;
import com.ITVDN.DFD.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CourierRepository courierRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Administrator saveAdmin(Administrator courier) {
        courier.addRole(Role.ADMINISTRATOR);
        adminRepository.save(courier);
        return courier;
    }

    public Administrator getAdmin(long id) {
        return adminRepository.findById(id).get();
    }

    public Set<Client> getAllClients() {
        return StreamSupport
                .stream(clientRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    public Set<Courier> getAllCouriers() {
        return StreamSupport
                .stream(courierRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    public Set<Restaurant> getAllRestaurants() {
        return StreamSupport
                .stream(restaurantRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

}
