package com.sda.project.wypozyczalnia.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

<<<<<<< HEAD:src/main/java/com/sda/project/wypozyczalnia/dto/Employee.java
=======

>>>>>>> adding CarService:src/main/java/com/sda/project/wypozyczalnia/dto/Employee.java
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private Position position;
    private String department;

    public Employee(String name, String surname, Position position, String department){
        this.department = department;
        this.name = name;
        this.surname = surname;
        this.position = position;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
