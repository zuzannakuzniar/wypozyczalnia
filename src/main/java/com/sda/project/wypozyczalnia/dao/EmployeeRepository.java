package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
