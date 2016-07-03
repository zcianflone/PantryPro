package com.example.zaccianflone.pantrypro.database;

import android.provider.ContactsContract;

import com.example.zaccianflone.pantrypro.Constants;
import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ben on 7/2/2016.
 */
public class DatabaseUpdate {

    // non-default constructor for creating a new recipe with items
    public DatabaseUpdate(String name, String description, List<String> items) {
        adding.setName(name);
        adding.setDescription(description);
        adding.setItemList(items);
    }

    public DatabaseUpdate(String name, String expire, int quantity, String unit) {
        adding.setName(name);
        adding.setExpdate(expire);
        adding.setQuantity(quantity);
        adding.setUnit(unit);
    }

    private Firebase ref;
    private Adding adding = new Adding();

    //Creates a new item in the pantry
    public void createNewItem() {
        ref = new Firebase(Constants.FIREBASE_URL).child("Items In Pantry");

        HashMap <String, Object> itemFacts = new HashMap<>();
        itemFacts.put("Unit", adding.getUnit());
        itemFacts.put("Quantity", adding.getQuantity());
        itemFacts.put("Expires", adding.getExpdate());

        HashMap <String, Object> item = new HashMap<>();
        item.put(adding.getName(), itemFacts);
        ref.updateChildren(item);

    }

    // Ben is currently working on this one
    public void createNewRecipe() {
        ref = new Firebase(Constants.FIREBASE_URL).child("Recipes");
        HashMap<String, Object> recipeFacts = new HashMap<>();

    }




}
