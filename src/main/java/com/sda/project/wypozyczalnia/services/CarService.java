package com.sda.project.wypozyczalnia.services;

import com.sda.project.wypozyczalnia.dao.CarRepository;
import com.sda.project.wypozyczalnia.model.Car;
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

    public List<Car> findByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public List<Car> findByModel(String model) {
        return carRepository.findByModel(model);
    }

    public List<Car> findByEngine(double engine) {
        return carRepository.findByEngine(engine);
    }

    public Car addNewCar(Car car){
        return carRepository.save(createNewCar(car));
    }

    public List<Car> getAllCars(){
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    public Car getOneCarById(Long id){
        return carRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Car.class.getName()));
    }

    public Car updateCarById(Long id, Car car){
        Car car1 = carRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Car.class.getName()));
        car1.setBrand(car.getBrand());
        car1.setEngine(car.getEngine());
//        car1.setEquipment(car.getEquipment());
        car1.setModel(car.getModel());
        car1.setPrice(car.getPrice());
        car1.setColor(car.getColor());
        return car1;
    }
    public Car deleteCarById (Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Car.class.getName()));

        carRepository.deleteById(id);
        return car;
    }

    private Car createNewCar(Car car) {
        Car result = new Car();
        result.setBrand(car.getBrand());
        result.setModel(car.getModel());
        result.setEngine(car.getEngine());
        result.setProductionYear(car.getProductionYear());
        result.setColor(car.getColor());
        result.setMileage(car.getMileage());
        result.setStatus(car.getStatus());
        result.setPrice(car.getPrice());
        return result;
    }

}
