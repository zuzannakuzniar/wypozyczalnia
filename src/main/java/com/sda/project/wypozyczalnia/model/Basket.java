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

    @OneToMany
    List<Orders> orders = new ArrayList<>();

}
