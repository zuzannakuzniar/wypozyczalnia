package com.sda.project.wypozyczalnia.controllers;

import com.sda.project.wypozyczalnia.model.Hire;
import com.sda.project.wypozyczalnia.model.User;
import com.sda.project.wypozyczalnia.services.HireService;
import com.sda.project.wypozyczalnia.services.UserService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hire/")
public class HireController {
    private HireService hireService;

    public HireController(HireService hireService) {
        this.hireService = hireService;
    }

    @PostMapping()
    public Hire addNewHire(@RequestBody Hire hireForm) {
        Hire savedHire = hireService.addNewHire(hireForm);
        return savedHire;
    }

    @GetMapping()
    public List<Hire> getAllHires() {
        return hireService.getAllHires();
    }

    @GetMapping("/{id}")
    public Hire getOneHireById(@PathVariable("id") Long id) {
        return hireService.getOneHireById(id);
    }




    @PutMapping("/{id}")
    public Hire updateHireById(@PathVariable("id") Long id, @RequestBody Hire hireForm) {
        return hireService.updateHireById(id, hireForm);
    }

    @DeleteMapping("/{id}")
    public void deleteHireById(@PathVariable("id") Long id) {
        hireService.deleteHireById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity handleObjectNotFoundException(ObjectNotFoundException onfe) {
        return ResponseEntity.notFound().build();
    }

}