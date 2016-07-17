package com.example.zaccianflone.pantrypro.model;

/**
 * Created by zaccianflone on 7/16/16.
 */
public class Ingredient {
    String name;
    String quantity;
    String units;
    String recipeName;

    public Ingredient() {
    }

    public Ingredient(String recipeName, String name, String quantity, String units) {
        this.recipeName = recipeName;
        this.name = name;
        this.quantity = quantity;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getUnits() {
        return units;
    }
}
