package com.sda.project.wypozyczalnia.dto;


import javax.persistence.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import java.util.List;


public class Car {

    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String model;
    private double engine;
    private double price;
    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private List<Equipment> equipment;

    public Car(String brand,String model,double engine, double price ){
        this.brand = brand;
        this.engine = engine;
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }
}
