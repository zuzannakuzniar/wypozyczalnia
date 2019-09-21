package com.sda.project.wypozyczalnia.model;




import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private double engine;
    private int productionYear;
    private String color;
    private double mileage;
    private double price;

    @OneToOne
    private Equipment equipment;

    @ManyToOne
    private Reservation reservation;

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

   /* *//*public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;*//*
    }*/

    /*@ManyToOne
    private Basket basket;*/

    public Car(String brand, String model, double engine, int productionYear, String color, double mileage,
                double price, Equipment equipment) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.productionYear = productionYear;
        this.color = color;
        this.mileage = mileage;

        this.price = price;
        this.equipment=equipment;
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

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
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
                ", price=" + price +
                ", equipment=" + equipment +
               /* ", basket=" + basket +*/
                '}';
    } //tu ewentnualnei usunac basket
}
