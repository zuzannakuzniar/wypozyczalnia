package com.sda.project.wypozyczalnia.extras;

public enum Status {
    AVAILABLE("Pojazd jest dostepny"),
    RENTED("Pojazd jest wypozyczony"),
    UNAVAILABLE_DAMAGED("Pojazd jest uszkodzony"),
    UNAVAILABLE_REPAIR("Pojazd jest w naprawie"),
    UNAVAILABLE_REVIEW("Pojazd nie posiada przegladu");

    public final String label;

    private Status(String label) {
        this.label = label;
    }

//    **GUIDE**
//    How to use:
//    System.out.println(BE.label);

}
