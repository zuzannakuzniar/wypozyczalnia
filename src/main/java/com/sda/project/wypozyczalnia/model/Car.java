package com.sda.project.wypozyczalnia.model;

import com.sda.project.wypozyczalnia.extras.Colors;
import com.sda.project.wypozyczalnia.extras.Status;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private double engine;
    private String productionYear;
    private Colors color;
    private double mileage;
    private Status status;
    private double price;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Basket basket;

    public Car(String brand, String model, double engine, String productionYear, Colors color, double mileage, Status status, double price) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.productionYear = productionYear;
        this.color = color;
        this.mileage = mileage;
        this.status = status;
        this.price = price;
    }

    public Car() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", productionYear='" + productionYear + '\'' +
                ", color=" + color +
                ", mileage=" + mileage +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}
