package com.sda.project.wypozyczalnia.controllers;


import com.sda.project.wypozyczalnia.extras.Role;
import com.sda.project.wypozyczalnia.model.Department;
import com.sda.project.wypozyczalnia.model.Employee;
import com.sda.project.wypozyczalnia.services.EmployeeService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees/")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping()
    public Employee addNewEmployee(@RequestBody Employee employeeForm) {
        Employee savedEmployee = employeeService.addNewEmployee(employeeForm);
        return savedEmployee;
    }

    @GetMapping()
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public Employee getOneEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getOneEmployeeById(id);
    }

    @GetMapping("{name}")
    public List<Employee> getEmployeesByName(@PathVariable("name") String name){
       return employeeService.findEmployeeByName(name);
    }

    @GetMapping("{Surname}")
    public List<Employee> getEmployeesBySurname(@PathVariable("surname") String surname){
        return employeeService.findEmployeeBySurname(surname);
    }

    @GetMapping("{role}")
    public List<Employee> getEmployeesByRole(@PathVariable("role") Role role){
        return employeeService.findEmployeeByRole(role);
    }

    @GetMapping("{department}")
    public List<Employee> getEmployeesByDepartments(@PathVariable("department") Department department){
        return employeeService.findEmployeeByDepartment(department);
    }

    @PutMapping("{id}")
    public Employee updateEmployeeById(@PathVariable("id") Long id, @RequestBody Employee employeeForm) {
        return employeeService.updateEmployeeById(id, employeeForm);
    }

    @DeleteMapping("{id}")
    public void deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity handleObjectNotFoundException(ObjectNotFoundException onfe) {
        return ResponseEntity.notFound().build();
    }
}
