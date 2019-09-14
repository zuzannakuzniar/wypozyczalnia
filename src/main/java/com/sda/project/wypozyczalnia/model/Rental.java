package com.sda.project.wypozyczalnia.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String domain;
    private String contactAddress;
    private String owner;
    private String logo;

    @OneToMany
    private List<Department> departments = new ArrayList<>();

    public Rental(String name, String domain, String contactAddress, String owner, String logo) {
        this.name = name;
        this.domain = domain;
        this.contactAddress = contactAddress;
        this.owner = owner;
        this.logo = logo;
    }

    public Rental() {
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

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", owner='" + owner + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
