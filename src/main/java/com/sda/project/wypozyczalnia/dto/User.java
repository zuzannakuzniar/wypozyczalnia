package com.sda.project.wypozyczalnia.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

<<<<<<< HEAD:src/main/java/com/sda/project/wypozyczalnia/model/User.java
=======

<<<<<<< HEAD



=======
>>>>>>> 558ecfe62e196eaa4ec4e9b0b992af9607489035:src/main/java/com/sda/project/wypozyczalnia/dto/User.java
>>>>>>> f859c041a6b2f1a1f0add225335d10d5179b5e02
public class User {

    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private String surname;
    private String email;
    private String dlsn;
    private String password;

    public User() {
    }

    public User(String name, String surname, String email, String dlsn, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dlsn = dlsn;
        this.password = password;
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
}
