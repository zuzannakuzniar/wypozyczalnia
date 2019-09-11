package com.sda.project.wypozyczalnia.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sda.project.wypozyczalnia.model.User;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserForm {

    private User name;
    private String surname;
    private String email;
    private String dlsn;
    private String password;

    public User getName() {
        return name;
    }

    public void setName(User name) {
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
