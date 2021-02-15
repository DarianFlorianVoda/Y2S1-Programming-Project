package com.company;

import java.io.Serializable;

public class Parkzone implements Serializable {

    //@spaces - the number of spaces from one parking zone - Int
    //@cartype - the type of the parking zone that is allowed - Enumeration Cartype

    private int spaces;
    private Cartype cartype;

    public Parkzone(int spaces, Cartype cartype) {
        this.spaces = spaces;
        this.cartype = cartype;
    }

    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }

    public void setCartype(Cartype cartype) {
        this.cartype = cartype;
    }

    public Cartype getCartype() {
        return cartype;
    }

    public int getSpaces() {
        return spaces;
    }

    @Override
    public String toString() {
        return "Parkzone{" +
                "spaces=" + spaces +
                ", cartype='" + cartype + '\'' +
                '}';
    }
}
