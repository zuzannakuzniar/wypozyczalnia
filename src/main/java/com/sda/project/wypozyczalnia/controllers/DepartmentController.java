package com.sda.project.wypozyczalnia.controllers;

import com.sda.project.wypozyczalnia.model.Department;
import com.sda.project.wypozyczalnia.services.DepartmentService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments/")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/create")
    public Department addNewDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.addNewDepartment(department);
        return savedDepartment;
    }

    @GetMapping("/findAll")
    public List<Department> getAllDepartments(@RequestParam(name = "address", required = false) String address) {
        if (!StringUtils.isEmpty(address)) {
            return departmentService.getDepartmentByAddress(address);
        }
        return departmentService.getAllDepartments();
    }

    @GetMapping("/find/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
        return departmentService.updateDepartmentById(id, department);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartmentById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity handleObjectNotFoundException(ObjectNotFoundException onfe) {
        return ResponseEntity.notFound().build();
    }

}