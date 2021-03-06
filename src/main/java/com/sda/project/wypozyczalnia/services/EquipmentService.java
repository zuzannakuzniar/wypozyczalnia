package com.sda.project.wypozyczalnia.services;

import com.google.common.collect.Lists;
import com.sda.project.wypozyczalnia.dao.EquipmentRepository;
import com.sda.project.wypozyczalnia.model.Equipment;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EquipmentService {

    private EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public Equipment addNewEquipment(Equipment equipment) {
        return equipmentRepository.save(createNewEquipment(equipment));
    }

    public List<Equipment> getEquipmentByDescription(String description) {
        return equipmentRepository.findByDescription(description);
    }

    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Equipment.class.getName()));
            }

    public List<Equipment> getAllEquipments() {
        return Lists.newArrayList(equipmentRepository.findAll());
    }

    public Equipment deleteEquipmentById (Long id) {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Equipment.class.getName()));

        equipmentRepository.deleteById(id);
        return equipment;
    }

    public Equipment updateEquipmentById(Long id, Equipment equipment) {
        Equipment foundEquipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Equipment.class.getName()));

        foundEquipment.setDescription(equipment.getDescription());

        return equipmentRepository.save(foundEquipment);
    }

    private Equipment createNewEquipment(Equipment equipment) {

        Equipment result = new Equipment();
        result.setType(equipment.getType());

        result.setDescription(equipment.getDescription());

        return result;
    }
}


