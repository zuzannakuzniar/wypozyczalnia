package com.sda.project.wypozyczalnia.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    List<Car> cars = new ArrayList<>();

   /* @OneToMany
    List<Orders> orders = new ArrayList<>();*/

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

   /* public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }*/

    public Basket(List<Car> cars, List<Orders> orders) {
        this.cars = cars;
       /* this.orders = orders;*/
    }

    public Basket() {
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", cars=" + cars +
                /*", orders=" + orders +*/
                '}';
    }
}
