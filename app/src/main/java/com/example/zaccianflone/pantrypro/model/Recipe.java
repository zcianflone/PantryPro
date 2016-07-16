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
    String description;
    ArrayList<String> ingredients = new ArrayList<String>();

    public Recipe() {
    }

    public Recipe(String name, String description, ArrayList<String> ingredients) throws ParseException {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getIngredient() {
        return ingredients;
    }
}
