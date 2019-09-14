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

    @PostMapping("/create")
    public Equipment addNewEquipment(@RequestBody Equipment equipment) {
        Equipment savedEquipment = equipmentService.addNewEquipment(equipment);
        return savedEquipment;
    }

    @GetMapping("/findAll")
    public List<Equipment> getAllEquipments(@RequestParam(name = "description", required = false) String description) {
        if (!StringUtils.isEmpty(description)) {
            return equipmentService.getEquipmentByDescription(description);
        }
        return equipmentService.getAllEquipments();
    }

    @GetMapping("/find/{id}")
    public Equipment getEquipmentById(@PathVariable("id") Long id) {
        return equipmentService.getEquipmentById(id);
    }

    @PutMapping("/update/{id}")
    public Equipment updateEquipment(@PathVariable("id") Long id, @RequestBody Equipment equipment) {
        return equipmentService.updateEquipmentById(id, equipment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEquipment(@PathVariable("id") Long id) {
        equipmentService.deleteEquipmentById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity handleObjectNotFoundException(ObjectNotFoundException onfe) {
        return ResponseEntity.notFound().build();
    }

}