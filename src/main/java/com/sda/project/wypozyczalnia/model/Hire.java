package com.sda.project.wypozyczalnia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String employee;
    private String date;
    private String reservation;
    private String comments;

    public Hire(Long id, String employee, String date, String reservation, String comments) {
        this.id = id;
        this.employee = employee;
        this.date = date;
        this.reservation = reservation;
        this.comments = comments;
    }

    public Hire() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Hire{" +
                "id=" + id +
                ", employee='" + employee + '\'' +
                ", date='" + date + '\'' +
                ", reservation='" + reservation + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
