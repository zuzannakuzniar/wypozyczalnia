package com.sda.project.wypozyczalnia.services;

import com.sda.project.wypozyczalnia.dao.EmployeeRepository;
import com.sda.project.wypozyczalnia.extras.Role;
import com.sda.project.wypozyczalnia.model.Employee;
import com.google.common.collect.Lists;
import org.hibernate.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> listOfEmployees(){
        return Lists.newArrayList(employeeRepository.findAll());
    }

    public Employee addNewEmployee(Employee employee){
        return employeeRepository.save(createNewEmployee(employee));
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id,Employee.class.getName()));
    }

    public void deleteEmployeeById(Long id){
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException(id,Employee.class.getName());
        }
    }

    public Employee updateEmployeeById(Long id, Employee employee){
        Employee foundEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Employee.class.getName()));
        foundEmployee.setRole(employee.getRole());
        foundEmployee.setDepartment(employee.getDepartment());
        foundEmployee.setSurname(employee.getSurname());
        foundEmployee.setName(employee.getName());
        return employeeRepository.save(foundEmployee);
    }

    private Employee createNewEmployee(Employee employee) {

        Employee result = new Employee();
        result.setName(employee.getName());
        result.setSurname(employee.getSurname());
        result.setDepartment(employee.getDepartment());
        result.setRole(Role.PRACOWNIK);

        return result;
    }
    
    private List<Employee> findEmployeeByName(String name){
        return employeeRepository.findByName(name);
    }
    
    private List<Employee> findEmployeeBySurname(String surname){
        return employeeRepository.findBySurname(surname);
    }

    private List<Employee> findEmployeeByRole(Role role){
        return employeeRepository.findByRole(role);
    }
    
    private List<Employee> findEmployeeByDepartment(String department){
        return employeeRepository.findByDepartment(department);
    }
}
