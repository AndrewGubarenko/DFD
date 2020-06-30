package com.ITVDN.DFD.repositories;

import com.ITVDN.DFD.entities.Courier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends CrudRepository<Courier, Long> {

}
