package com.sda.project.wypozyczalnia.model;

//import com.sda.project.wypozyczalnia.extras.Privileges;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String dlsn;
    private String password;
//    private Privileges privileges;

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

//    public Privileges getPrivileges() {
//        return privileges;
//    }
//
//    public void setPrivileges(Privileges privileges) {
//        this.privileges = privileges;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dlsn='" + dlsn + '\'' +
                ", password='" + password + '\'' +
//                ", privileges=" + privileges +
                '}';
    }
}
