package com.sda.project.wypozyczalnia.dto;

import com.sda.project.wypozyczalnia.model.User;

public class UserDTO {

    private Long id;
    private User name;
    private String surname;
    private String email;
    private String dlsn;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public static UserDTO fromUser(User user) {
        UserDTO result = new UserDTO();
        result.id = user.getId();
        result.name = user.getName();
        result.surname = user.getSurname();
        result.email = user.getEmail();
        result.dlsn = user.getDlsn();
        result.password = user.getPassword();
        return result;
    }
}
