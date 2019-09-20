package com.sda.project.wypozyczalnia.controllers;

import com.sda.project.wypozyczalnia.model.Address;
import com.sda.project.wypozyczalnia.services.AddressService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses/") // niedziała
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService=addressService;
    }

    @GetMapping()
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @PostMapping()
    public Address addNewAddress(@RequestBody Address addressForm) {
        Address savedAddress = addressService.addNewAddress(addressForm);
        return savedAddress;
    }


    @GetMapping("/{id}")
    public Address getOneAddressById(@PathVariable("id") Long id) {
        return addressService.getOneAddressById(id);
    }

    @GetMapping("/{city}")
    public List<Address> getCarsByBrand(@PathVariable("city") String city){
        return addressService.findByCity(city);
    }



    @PutMapping("/{id}")
    public Address updateAddressById(@PathVariable("id") Long id, @RequestBody Address addressForm) {
        return addressService.updateAddressById(id, addressForm);
    }

    @DeleteMapping("/{id}")
    public void deleteAddressById(@PathVariable("id") Long id) {
        addressService.deleteAddressById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity handleObjectNotFoundException(ObjectNotFoundException onfe) {
        return ResponseEntity.notFound().build();
    }
}
