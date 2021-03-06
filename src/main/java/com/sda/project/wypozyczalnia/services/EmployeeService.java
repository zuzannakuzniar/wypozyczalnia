package com.sda.project.wypozyczalnia.services;

import com.sda.project.wypozyczalnia.dao.EmployeeRepository;

import com.sda.project.wypozyczalnia.model.Department;
import com.sda.project.wypozyczalnia.model.Employee;
import com.google.common.collect.Lists;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return Lists.newArrayList(employeeRepository.findAll());
    }

    public Employee addNewEmployee(Employee employee){
        return employeeRepository.save(createNewEmployee(employee));
    }

    public Employee getOneEmployeeById(Long id){
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
        /*foundEmployee.setRole(employee.getRole());*/
        /*foundEmployee.setDepartment(employee.getDepartment());*/
        foundEmployee.setSurname(employee.getSurname());
        foundEmployee.setName(employee.getName());
        return employeeRepository.save(foundEmployee);
    }

    private Employee createNewEmployee(Employee employee) {

        Employee result = new Employee();
        result.setName(employee.getName());
        result.setSurname(employee.getSurname());
        /*result.setDepartment(employee.getDepartment());*/
        /*result.setRole(Role.PRACOWNIK);*/

        return result;
    }
    
    public List<Employee> findEmployeeByName(String name){
        return employeeRepository.findByName(name);
    }
    
    public List<Employee> findEmployeeBySurname(String surname){
        return employeeRepository.findBySurname(surname);
    }

 /*   public List<Employee> findEmployeeByRole(Role role){
        return employeeRepository.findByRole(role);*/
    }
    
  /*  public List<Employee> findEmployeeByDepartment(Department department){
        return employeeRepository.findByDepartment(department);
    }*/
