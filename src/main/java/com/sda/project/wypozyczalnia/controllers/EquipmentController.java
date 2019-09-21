package com.sda.project.wypozyczalnia.controllers;

import com.sda.project.wypozyczalnia.model.Equipment;
import com.sda.project.wypozyczalnia.services.EquipmentService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/equipments/")
public class EquipmentController {
    private EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @PostMapping()
    public Equipment addNewEquipment(@RequestBody Equipment equipment) {
        Equipment savedEquipment = equipmentService.addNewEquipment(equipment);
        return savedEquipment;
    }

    @GetMapping()
    public List<Equipment> getAllEquipments() {
        return equipmentService.getAllEquipments();
    }

    @GetMapping("/id/{id}")
    public Equipment getEquipmentById(@PathVariable("id") Long id) {
        return equipmentService.getEquipmentById(id);
    }

    @GetMapping("/description/{description}")
    public List<Equipment>  getEquipmentsByDescription(@PathVariable("description") String description){
       return equipmentService.getEquipmentByDescription(description);
    }

    @PutMapping("{id}")
    public Equipment updateEquipmentById(@PathVariable("id") Long id, @RequestBody Equipment equipment) {
        return equipmentService.updateEquipmentById(id, equipment);
    }

    @DeleteMapping("{id}")
    public void deleteEquipmentById(@PathVariable("id") Long id) {
        equipmentService.deleteEquipmentById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity handleObjectNotFoundException(ObjectNotFoundException onfe) {
        return ResponseEntity.notFound().build();
    }

}