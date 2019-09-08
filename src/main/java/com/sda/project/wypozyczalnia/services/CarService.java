package com.sda.project.wypozyczalnia.services;


import com.sda.project.wypozyczalnia.dao.CarRepository;
import com.sda.project.wypozyczalnia.dto.Car;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository){
        this.carRepository=carRepository;
    }

    public Car addNewCar(Car car){
        return carRepository.save(car);
    }

    public List<Car> getAllCars(){
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(c ->cars.add(c));
        return cars;
    }

    public Car getOneCarById(Long id){
        return carRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Car.class.getName()));
    }

    public Car updateCar(Long id, Car car){
        Car car1 = carRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Car.class.getName()));
        car1.setBrand(car.getBrand());
        car1.setEngine(car.getEngine());
        car1.setEquipment(car.getEquipment());
        car1.setModel(car.getModel());
        car1.setPrice(car.getPrice());
        return car1;
    }
    public void deleteById(Long id){
        Car id1 = carRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id,Car.class.getName()));
        carRepository.deleteById(id);
    }

}
