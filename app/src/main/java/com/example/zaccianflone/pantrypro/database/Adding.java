package com.example.zaccianflone.pantrypro.database;

/**
 * Created by Ben on 7/2/2016.
 *
 * This will handle the adding items, recipes, and grocery lists
 */
public class Adding {
    private String type;
    private String name;
    private String expdate;
    private int quantity;
    private String unit;
    private String description;
    private String item;

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getExpdate() {
        return expdate;
    }
    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getUnit() {
        return unit;
    }
    public  void setUnit(String unit) {
        this.unit = unit;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
}
