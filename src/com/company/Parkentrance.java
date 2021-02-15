package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Parkentrance implements Serializable {

    //@car - the list of cars which are of type - class Car
    //@entry_time - a list of entry time for each car - String
    //@exit_time - a list of exit time for each car - String

    private ArrayList<Car> car = new ArrayList<>();
    private ArrayList<String> entry_time = new ArrayList<>();
    private ArrayList<String> exit_time = new ArrayList<>();

    public Parkentrance(ArrayList<Car> car, ArrayList<String> entry_time, ArrayList<String> exit_time) {
        this.car = car;
        this.entry_time = entry_time;
        this.exit_time = exit_time;
    }

    public int getnumbercars()
    {
        return car.size();
    }
    public ArrayList<Car> getCar() {
        return car;
    }

    public void setEntry_time(ArrayList<String> entry_time) {
        this.entry_time = entry_time;
    }

    public void setExit_time(ArrayList<String> exit_time) {
        this.exit_time = exit_time;
    }

    public ArrayList<String> getEntry_time() {
        return entry_time;
    }

    public ArrayList<String> getExit_time() {
        return exit_time;
    }

    public void setCar(ArrayList<Car> car) {
        this.car = car;
    }



    @Override
    public String toString() {
        return "Parkentrance{" +
                "car=" + car +
                ", entry_time='" + entry_time + '\'' +
                ", exit_time='" + exit_time + '\'' +
                '}';
    }
}
