package com.ITVDN.DFD.repositories;

import com.ITVDN.DFD.entities.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
}
