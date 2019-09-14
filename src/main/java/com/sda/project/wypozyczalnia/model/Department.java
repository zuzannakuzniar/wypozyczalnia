package com.sda.project.wypozyczalnia.model;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Rental rental;

    @OneToOne(mappedBy = "department")
    private Address address;

    private String availableCarList;

    public Department(Address address, String employeeList, String availableCarList) {
        this.address = address;
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


    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
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
                ", availableCarList='" + availableCarList + '\'' +
                '}';
    }
}