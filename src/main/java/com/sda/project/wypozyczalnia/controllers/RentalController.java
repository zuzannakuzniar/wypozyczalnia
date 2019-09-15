package com.sda.project.wypozyczalnia.controllers;

import com.sda.project.wypozyczalnia.model.Rental;
import com.sda.project.wypozyczalnia.services.RentalService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rentals/")
public class RentalController {
    private RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping()
    public Rental addNewRental(@RequestBody Rental rental) {
        Rental savedRental = rentalService.addNewRental(rental);
        return savedRental;
    }

    @GetMapping()
    public List<Rental> getAllRental() {
        return rentalService.getAllRental();
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable("id") Long id) {
        return rentalService.getRentalById(id);
    }

    @PutMapping("/{id}")
    public Rental updateOrders(@PathVariable("id") Long id, @RequestBody Rental rental) {
        return rentalService.updateRentalById(id, rental);
    }

    @DeleteMapping("/{id}")
    public void deleteOrders(@PathVariable("id") Long id) {
        rentalService.deleteRentalById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity handleObjectNotFoundException(ObjectNotFoundException onfe) {
        return ResponseEntity.notFound().build();
    }

}