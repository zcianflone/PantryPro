package com.example.zaccianflone.pantrypro.model;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by kylor on 7/15/2016.
 */
public class Recipe {

    String name;
    String directions;
    long invertedTime;


    public Recipe() {
    }

    public Recipe(String name, String directions) throws ParseException {
        this.name = name;
        this.directions = directions;

        long d = (long) new Date().getTime();
        this.invertedTime = 0-d;
    }

    public String getName() {
        return name;
    }

    public String getDirections() {
        return directions;
    }

    public long getInvertedTime() {
        return invertedTime;
    }
}
