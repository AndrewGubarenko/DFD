package com.ITVDN.DFD.repositories;

import com.ITVDN.DFD.entities.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Administrator, Long> {

}
