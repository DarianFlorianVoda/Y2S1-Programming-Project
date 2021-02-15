package com.company;

import java.io.Serializable;

public class Car implements Serializable {

    //@Carnumber - a string that gives the Car plate for each car
    //@custype - a Customer Enumeration which gives info about the customer type: Subscribed or Ocasionally
    //@cartype - the type of the car that is introduced

    private String Carnumber;
    private Customer custype;
    private Cartype cartype;

    public Car(String Carnumber, Customer custype, Cartype cartype)
    {
        this.Carnumber = Carnumber;
        this.custype = custype;
        this.cartype = cartype;
    }

    public Car()
    {
        this.Carnumber = null;
        this.custype = null;
        this.cartype = null;
    }


    public void setCustype(Customer custype) {
        this.custype = custype;
    }

    public void setCarnumber(String carnumber) {
        Carnumber = carnumber;
    }

    public String getCarnumber() {
        return Carnumber;
    }

    public Customer getCustype() {
        return custype;
    }

    public Cartype getCartype() {
        return cartype;
    }

    public void setCartype(Cartype cartype) {
        this.cartype = cartype;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Carnumber='" + Carnumber + '\'' +
                ", custype=" + custype +
                ", cartype=" + cartype +
                '}';
    }
}
