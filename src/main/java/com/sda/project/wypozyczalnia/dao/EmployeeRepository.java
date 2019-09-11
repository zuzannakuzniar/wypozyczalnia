package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.extras.Role;
import com.sda.project.wypozyczalnia.model.Employee;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByName(String name);
    List<Employee> findBySurname(String surname);
    List<Employee> findByPosition(Role role);
    List<Employee> findByDepartment(String department);
}
