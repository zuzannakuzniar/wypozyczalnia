package com.sda.project.wypozyczalnia.extras;

import java.util.Objects;

public class Role {

    public static final Role MANAGER = new Role("Manager");
    public static final Role USER = new Role("Uzytkownik");

    private String name;

    public Role(String name) {
        this.name = name;
    }

    public static Role getMANAGER() {
        return MANAGER;
    }

    public static Role getUSER() {
        return USER;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return name.equals(role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
    //    **GUIDE**
    //    How to use:
    //    Role r = Role.MANAGER;
}
