package com.sda.project.wypozyczalnia.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Employee employee;
    private java.sql.Date date;
    @OneToOne
    private Reservation reservation;
    private String comments;

    public void setDate(Date date) {
        this.date = date;
    }



    public Hire(Long id, Employee employee, Date date, Reservation reservation, String comments) {
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
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
                ", employee=" + employee +
                ", date=" + date +
                ", reservation='" + reservation + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
