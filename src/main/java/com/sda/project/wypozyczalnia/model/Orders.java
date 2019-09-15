package com.sda.project.wypozyczalnia.model;

import javax.persistence.*;

@Entity
public class  Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double summary;

    @ManyToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Basket basket;

    public Orders(double summary) {
        this.summary = summary;
    }

    public Orders() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSummary() {
        return summary;
    }

    public void setSummary(double summary) {
        this.summary = summary;
    }
}
