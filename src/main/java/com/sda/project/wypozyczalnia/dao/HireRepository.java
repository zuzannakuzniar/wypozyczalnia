package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.model.Hire;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HireRepository extends CrudRepository<Hire, Long> {
    List<Hire> findByEmployee(String employee);
}
