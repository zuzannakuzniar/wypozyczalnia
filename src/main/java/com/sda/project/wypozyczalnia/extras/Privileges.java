//package com.sda.project.wypozyczalnia.extras;
//
//import java.util.Objects;
//
//public class Privileges {
//
//    public static final Privileges MANAGER = new Privileges("Manager");
//    public static final Privileges USER = new Privileges("Uzytkownik");
//
//    private String name;
//
//    public Privileges(String name) {
//        this.name = name;
//    }
//
//    public static Privileges getMANAGER() {
//        return MANAGER;
//    }
//
//    public static Privileges getUSER() {
//        return USER;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Privileges privileges = (Privileges) o;
//        return name.equals(privileges.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
//
//    @Override
//    public String toString() {
//        return "Privileges{" +
//                "name='" + name + '\'' +
//                '}';
//    }
//    //    **GUIDE**
//    //    How to use:
//    //    Privileges r = Privileges.MANAGER;
//}
