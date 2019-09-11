package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.model.Car;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    List<Car> findByModel(String model);
    List<Car> findByEngine(double engine);

}
