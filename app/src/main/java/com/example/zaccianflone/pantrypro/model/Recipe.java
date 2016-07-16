package com.example.zaccianflone.pantrypro.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kylor on 7/15/2016.
 */
public class Recipe {

    String name;
    String directions;
    ArrayList<String> ingredients = new ArrayList<String>();

    public Recipe() {
    }

    public Recipe(String name, String directions, ArrayList<String> ingredients) throws ParseException {
        this.name = name;
        this.directions = directions;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getDirections() {
        return directions;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }
}
