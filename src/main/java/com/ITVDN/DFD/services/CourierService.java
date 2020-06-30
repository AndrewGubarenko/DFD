package com.ITVDN.DFD.services;

import com.ITVDN.DFD.entities.Courier;
import com.ITVDN.DFD.repositories.CourierRepository;
import com.ITVDN.DFD.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourierService {

    @Autowired
    private CourierRepository courierRepository;

    public Courier saveCourier(Courier courier) {
        courier.addRole(Role.COURIER);
        courierRepository.save(courier);
        return courier;
    }

    public Courier getCourier(long id) {
        return courierRepository.findById(id).get();
    }
}
