package com.example.zaccianflone.pantrypro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.firebase.client.ServerValue;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;

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
    private HashMap<String, Object> timestampLastChanged;

    public PantryItem() {
    }

    public PantryItem(String name, String expDate, String quantity, String unitType) throws ParseException {
        this.name = name;
        this.quantity = quantity;
        this.unitType = unitType;

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Date expD = formatter.parse(expDate);

        this.expDate = (long) expD.getTime();
        this.textExpDate = expDate;


        HashMap<String, Object> timestampLastChangedObj = new HashMap<String, Object>();
        timestampLastChangedObj.put("timestamp", ServerValue.TIMESTAMP);
        this.timestampLastChanged = timestampLastChangedObj;

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

    public HashMap<String, Object> getTimestampLastChanged() {
        return timestampLastChanged;
    }

    public long getInvertedTime(){return invertedTime;}

    @JsonIgnore
    public long getTimestampLastChangedLong() {
        return (long) timestampLastChanged.get("timestamp");
    }


}
