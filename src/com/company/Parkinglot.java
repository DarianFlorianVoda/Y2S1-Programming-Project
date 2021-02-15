package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Parkinglot implements Serializable {

    //@entrance - A list of type class Parkentrance which is giving all the entrances for one parking lot
    //@zone - A list of type class Parkzone which is giving all the zones for one parking lot

    private ArrayList<Parkentrance> entrance;
    private ArrayList<Parkzone> zone;

    public Parkinglot(ArrayList<Parkentrance> entrance, ArrayList<Parkzone> zone) {
        this.entrance = entrance;
        this.zone = zone;
    }


    //getnrEntrances - function that returns the nr. of entrances

    public int getnrEntrances() {
        int s = 0;
        for(Parkentrance k: entrance)
        {
            s = s + k.getnumbercars();
        }
        return s;
    }

    //gernrSpaces - function that returns the nr. of spaces

    public int getnrSpaces()
    {
        int s = 0;
        for(Parkzone y: zone)
        {
            s = s+y.getSpaces();
        }
        return s;
    }

    @Override
    public String toString() {
        return "Parkinglot{" +
                "entrance=" + entrance +
                ", zone=" + zone +
                '}';
    }
}
