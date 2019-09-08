package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.dto.Car;


import com.sda.project.wypozyczalnia.dto.Employee;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CarRepository extends CrudRepository<Car, Long> {



    List<Car> findByName(String name);
    List<Car> findByModel(String model);
    List<Car> findByEngine(double engine);

}
