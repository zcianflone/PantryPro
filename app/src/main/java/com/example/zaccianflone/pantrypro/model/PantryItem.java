package com.example.zaccianflone.pantrypro.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zaccianflone on 7/7/16.
 */
public class PantryItem {

    String name;
    long expDate;
    String textExpDate;
    String quantity;
    String unitType;
    long invertedTime;
    String group;


    public PantryItem() {
    }

    public PantryItem(String name, String expDate, String quantity, String unitType, String group) throws ParseException {
        this.name = name;
        this.quantity = quantity;
        this.unitType = unitType;
        this.group = group;

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date expD = formatter.parse(expDate);

        this.expDate = (long) expD.getTime();
        this.textExpDate = expDate;

        long d = (long) new Date().getTime();
        this.invertedTime = 0-d;
    }

    public String getTextExpDate() {
        return textExpDate;
    }

    public long getExpDate() {
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

    public long getInvertedTime(){return invertedTime;}


    public String getGroup() {
        return group;
    }
}
