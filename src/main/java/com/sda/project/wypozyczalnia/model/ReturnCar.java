package com.sda.project.wypozyczalnia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReturnCar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String employee;
    private String returnDate;
    private String reservation;
    private String supplement;
    private String comments;

    public ReturnCar(Long id, String employee, String returnDate, String reservation, String supplement, String comments) {
        this.id = id;
        this.employee = employee;
        this.returnDate = returnDate;
        this.reservation = reservation;
        this.supplement = supplement;
        this.comments = comments;
    }

    public ReturnCar() {
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

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ReturnCar{" +
                "id=" + id +
                ", employee='" + employee + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", reservation='" + reservation + '\'' +
                ", supplement='" + supplement + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
