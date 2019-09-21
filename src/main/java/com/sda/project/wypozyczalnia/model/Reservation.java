package com.sda.project.wypozyczalnia.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private java.sql.Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



   /* @ManyToOne
    private User user;*/

   @OneToMany
    private List<Car> cars;
    private String startReservation;
    private String endReservation;
    private String departmentRent;
    private String departmentReturn;
    private double price;

    public Reservation(Date date/*, User user*/, Car car, String startReservation, String endReservation, String departmentRent, String departmentReturn, double price) {
        this.date = date;

        /*this.user = user;*/
       /* this.car = car;*/
        this.startReservation = startReservation;
        this.endReservation = endReservation;
        this.departmentRent = departmentRent;
        this.departmentReturn = departmentReturn;
        this.price = price;
    }

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


   /* public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/


   /* public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
*/
    public String getStartReservation() {
        return startReservation;
    }

    public void setStartReservation(String startReservation) {
        this.startReservation = startReservation;
    }

    public String getEndReservation() {
        return endReservation;
    }

    public void setEndReservation(String endReservation) {
        this.endReservation = endReservation;
    }

    public String getDepartmentRent() {
        return departmentRent;
    }

    public void setDepartmentRent(String departmentRent) {
        this.departmentRent = departmentRent;
    }

    public String getDepartmentReturn() {
        return departmentReturn;
    }

    public void setDepartmentReturn(String departmentReturn) {
        this.departmentReturn = departmentReturn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", date=" + date +
                ", cars=" + cars +
                ", startReservation='" + startReservation + '\'' +
                ", endReservation='" + endReservation + '\'' +
                ", departmentRent='" + departmentRent + '\'' +
                ", departmentReturn='" + departmentReturn + '\'' +
                ", price=" + price +
                '}';
    }
}
