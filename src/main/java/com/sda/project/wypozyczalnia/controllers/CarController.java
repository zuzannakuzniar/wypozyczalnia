package com.sda.project.wypozyczalnia.controllers;

import com.sda.project.wypozyczalnia.model.Car;
import com.sda.project.wypozyczalnia.services.CarService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars/")
public class CarController {

    private CarService carService;

    public CarController(CarService carService){
        this.carService=carService;
    }

    @PostMapping()
    public Car addNewCar(@RequestBody Car carForm) {
        Car savedCar = carService.addNewCar(carForm);
        return savedCar;
    }

    @GetMapping()
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getOneCarById(@PathVariable("id") Long id) {
        return carService.getOneCarById(id);
    }

    @GetMapping("/{brand}")
    public List<Car> getCarsByBrand(@PathVariable("brand") String brand){
        return carService.findByBrand(brand);
    }

    @GetMapping("/{model}")
    public List<Car> getCarsByModel(@PathVariable("model") String model){
        return carService.findByModel(model);
    }

    @GetMapping("/{engine}")
    public List<Car> getCarsByEngine(@PathVariable("engine") double engine){
        return carService.findByEngine(engine);
    }

    @PutMapping("/{id}")
    public Car updateCarById(@PathVariable("id") Long id, @RequestBody Car carForm) {
        return carService.updateCarById(id, carForm);
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable("id") Long id) {
        carService.deleteCarById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity handleObjectNotFoundException(ObjectNotFoundException onfe) {
        return ResponseEntity.notFound().build();
    }



}
