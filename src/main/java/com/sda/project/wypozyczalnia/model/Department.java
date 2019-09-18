package com.sda.project.wypozyczalnia.model;

import javax.persistence.*;

import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Rental rental;

    @OneToOne
    @JoinColumn(name = "addressId")
    private Address address;

    private String availableCarList;

    @OneToMany
    private List<Employee> employees;

    public Department(Address address, List<Employee> employees, String availableCarList) {
        this.address = address;
        this.employees = employees;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getAvailableCarList() {
        return availableCarList;
    }

    public void setAvailableCarList(String availableCarList) {
        this.availableCarList = availableCarList;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", rental=" + rental +
                ", address=" + address +
                ", availableCarList='" + availableCarList + '\'' +
                ", employees=" + employees +
                '}';
    }
}
