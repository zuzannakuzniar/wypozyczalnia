package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.model.Equipment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EquipmentRepository extends CrudRepository<Equipment, Long> {
    List<Equipment> findByDescription(String description);
}
