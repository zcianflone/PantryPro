package com.example.zaccianflone.pantrypro.pantry;

import com.example.zaccianflone.pantrypro.database.Create;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ben on 7/12/2016.
 */

public class Item {

    private String quantity;
    private String ingredient;
    private String unitType;

    public Item(String quantity, String ingredient, String unitType) {
        this.quantity = quantity;
        this.ingredient = ingredient;
        this.unitType = unitType;
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
//    public void addOrEdit(List<String> items) {
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("Expiration", items.get(1));
//        map.put("Quantity", items.get(2));
//        map.put("Unit", items.get(3));
//
//        HashMap<String, Object> head = new HashMap<>();
//        head.put(items.get(0), map);
//
//        Create create = new Create();
//        create.execute(head, "Item");
//    }
//
//    public void remove(List<String> items) {
//
//    }
}
