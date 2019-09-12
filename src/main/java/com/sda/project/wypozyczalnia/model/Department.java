package com.sda.project.wypozyczalnia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;
    private String employeeList;
    private String availableCarList;

    public Department(String address, String employeeList, String availableCarList) {
        this.address = address;
        this.employeeList = employeeList;
        this.availableCarList = availableCarList;
    }

    public Department() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(String employeeList) {
        this.employeeList = employeeList;
    }

    public String getAvailableCarList() {
        return availableCarList;
    }

    public void setAvailableCarList(String availableCarList) {
        this.availableCarList = availableCarList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", employeeList='" + employeeList + '\'' +
                ", availableCarList='" + availableCarList + '\'' +
                '}';
    }
}
