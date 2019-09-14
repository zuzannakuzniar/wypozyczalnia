package com.sda.project.wypozyczalnia.controllers;


import com.sda.project.wypozyczalnia.model.Employee;
import com.sda.project.wypozyczalnia.services.EmployeeService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/employee/")
    public class EmployeeController {

        private EmployeeService employeeService;



        public EmployeeController(EmployeeService employeeService){
            this.employeeService=employeeService;
        }


        @PostMapping("/add/")
        public Employee addNewEmployee(@RequestBody Employee employeeForm) {
            Employee savedEmployee = employeeService.addNewEmployee(employeeForm);
            return savedEmployee;
        }

        @GetMapping(("/get/"))
        public List<Employee> getAllEmployees(@RequestParam(name = "employees", required = false) Employee employees) {
            if (!StringUtils.isEmpty(employees)) {
                return employeeService.getAllEmployees();
            }
            return employeeService.getAllEmployees();
        }

        @GetMapping("{id}")
        public Employee getEmployeeById(@PathVariable("id") Long id) {
            return employeeService.getEmployeeById(id);
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
