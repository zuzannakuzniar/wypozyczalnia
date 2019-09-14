package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.model.Rental;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentalRepository extends CrudRepository<Rental, Long> {
    List<Rental> findByName(String name);
}
