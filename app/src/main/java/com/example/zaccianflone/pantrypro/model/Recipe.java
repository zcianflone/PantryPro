package com.example.zaccianflone.pantrypro.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kylor on 7/15/2016.
 */
public class Recipe {

    String name;
    String description;
    String quantity;
    String ingredient;
    String unitType;

    public Recipe() {

    }

    public Recipe(String name, String description, String quantity, String ingredient, String unitType) throws ParseException {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.unitType = unitType;
        this.ingredient = ingredient;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getIngredient() {
        return ingredient;
    }

    public String getUnitType() {
        return unitType;
    }

}
