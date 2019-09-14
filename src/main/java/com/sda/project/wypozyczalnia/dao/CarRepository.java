package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
