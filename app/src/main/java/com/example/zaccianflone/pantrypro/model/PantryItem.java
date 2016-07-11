package com.example.zaccianflone.pantrypro.model;

/**
 * Created by zaccianflone on 7/7/16.
 */
public class PantryItem {

    String name;
    String expDate;
    String quantity;
    String unitType;

    public PantryItem() {
    }

    public PantryItem(String name, String expDate, String quantity, String unitType) {
        this.name = name;
        this.expDate = expDate;
        this.quantity = quantity;
        this.unitType = unitType;
    }

    public String getExpDate() {
        return expDate;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getUnitType() {
        return unitType;
    }
}
