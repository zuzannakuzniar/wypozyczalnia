package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.dto.Employee;

import com.sda.project.wypozyczalnia.dto.Position;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByName(String name);
    List<Employee> findBySurname(String surname);
    List<Employee> findByPosition(Position position);
    List<Employee> findByDepartment(String department);
}
