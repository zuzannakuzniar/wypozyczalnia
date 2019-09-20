package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findByCity(String city);
}
