package com.sda.project.wypozyczalnia.services;

import com.google.common.collect.Lists;
import com.sda.project.wypozyczalnia.dao.DepartmentRepository;
import com.sda.project.wypozyczalnia.model.Department;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department addNewDepartment(Department department) {
        return departmentRepository.save(createNewDepartment(department));
    }

    public List<Department> getDepartmentByAddress(String address) {
        return departmentRepository.findByAddress(address);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Department.class.getName()));
            }

    public List<Department> getAllDepartments() {
        return Lists.newArrayList(departmentRepository.findAll());
    }

    public Department deleteDepartmentById (Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Department.class.getName()));

        departmentRepository.deleteById(id);
        return department;
    }

    public Department updateDepartmentById(Long id, Department department) {
        Department foundDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Department.class.getName()));

        foundDepartment.setAddress(department.getAddress());

        return departmentRepository.save(foundDepartment);
    }

    private Department createNewDepartment(Department department) {

        Department result = new Department();

        result.setAddress(department.getAddress());

        return result;
    }
}


