package com.ITVDN.DFD.repositories;

import com.ITVDN.DFD.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}
