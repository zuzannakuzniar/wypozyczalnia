package com.sda.project.wypozyczalnia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employee;
    private java.sql.Date date;
    private java.sql.Time time;
    private java.sql.Timestamp timestamp;
    private String reservation;
    private String comments;

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Hire(Long id, String employee, Date date,Time time,Timestamp timestamp, String reservation, String comments) {
        this.id = id;
        this.employee = employee;
        this.date = date;
        this.time=time;
        this.timestamp=timestamp;
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
                ", date=" + date +
                ", time=" + time +
                ", timestamp=" + timestamp +
                ", reservation='" + reservation + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
