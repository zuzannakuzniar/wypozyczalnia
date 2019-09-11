package com.sda.project.wypozyczalnia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Order {

    public Order() {
    }

    public Order(double summaryPayment, Date dateOrder) {
        this.summaryPayment = summaryPayment;
        this.dateOrder = dateOrder;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double summaryPayment;
    private Date dateOrder;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public double getSummaryPayment() {
        return summaryPayment;
    }

    public void setSummaryPayment(double summaryPayment) {
        this.summaryPayment = summaryPayment;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }
}

