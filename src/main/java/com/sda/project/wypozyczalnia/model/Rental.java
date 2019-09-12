package com.sda.project.wypozyczalnia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String domain;
    private String contactAddress;
    private String owner;
    private String logo;
    private String departmentList;

    public Rental(String name, String domain, String contactAddress, String owner, String logo, String departmentList) {
        this.name = name;
        this.domain = domain;
        this.contactAddress = contactAddress;
        this.owner = owner;
        this.logo = logo;
        this.departmentList = departmentList;
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

    public String getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(String departmentList) {
        this.departmentList = departmentList;
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
                ", departmentList='" + departmentList + '\'' +
                '}';
    }
}
