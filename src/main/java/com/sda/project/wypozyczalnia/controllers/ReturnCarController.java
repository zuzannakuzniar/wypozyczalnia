package com.sda.project.wypozyczalnia.controllers;

import com.sda.project.wypozyczalnia.model.ReturnCar;
import com.sda.project.wypozyczalnia.services.ReturnCarService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/returnCars")
public class ReturnCarController {
    private ReturnCarService returnCarService;

    public ReturnCarController(ReturnCarService returnCarService) {
        this.returnCarService = returnCarService;
    }

    @PostMapping()
    public ReturnCar addNewReturnCar(@RequestBody ReturnCar returnCar) {
        ReturnCar savedReservation = returnCarService.addNewReturnCar(returnCar);
        return savedReservation;
    }

    @GetMapping()
    public List<ReturnCar> getAllReturnCar() {
        return returnCarService.getAllReturnCar();
    }

    @GetMapping("/{id}")
    public ReturnCar getReturnCarById(@PathVariable("id") Long id) {
        return returnCarService.getReturnCarById(id);
    }

    @PutMapping("/{id}")
    public ReturnCar updateReturnCar(@PathVariable("id") Long id, @RequestBody ReturnCar returnCar) {
        return returnCarService.updateReturnCarById(id, returnCar);
    }

    @DeleteMapping("/{id}")
    public void deleteReturnCar(@PathVariable("id") Long id) {
        returnCarService.deleteReturnCarById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity handleObjectNotFoundException(ObjectNotFoundException onfe) {
        return ResponseEntity.notFound().build();
    }

}