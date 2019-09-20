package com.sda.project.wypozyczalnia.model;





import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Reservation> reservation = new ArrayList<>();

    private String name;
    private String surname;
    private String email;
    private String dlsn;
    private String password;




    public User(String name, String surname, String email, String dlsn, String password/*, Privileges privileges*/) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dlsn = dlsn;
        this.password = password;
//        this.privileges = privileges;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDlsn() {
        return dlsn;
    }

    public void setDlsn(String dlsn) {
        this.dlsn = dlsn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", reservation=" + reservation +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dlsn='" + dlsn + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
