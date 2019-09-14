package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.model.Department;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    List<Department> findByAddress(String address);
}
