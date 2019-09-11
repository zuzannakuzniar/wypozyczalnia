package com.sda.project.wypozyczalnia.model;

import com.sda.project.wypozyczalnia.extras.Role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private Role role;
    private String department;

    public Employee(String name, String surname, Role role, String department){
        this.department = department;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
