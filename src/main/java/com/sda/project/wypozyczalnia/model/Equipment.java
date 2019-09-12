package com.sda.project.wypozyczalnia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Equipment {


    @Id
    @GeneratedValue
    private Long id;

    private String decription;

    public Equipment(String decription) {
        this.decription = decription;
    }

    public Equipment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getDecription() {
        return decription;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", decription='" + decription + '\'' +
                '}';
    }
}
