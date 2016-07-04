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

    private Firebase ref = new Firebase(Constants.FIREBASE_SAVE);
    private Adding adding = new Adding();


    // creating a new recipe with items or a grocery list with items
    public DatabaseUpdate(String name, String description, HashMap<String, Object> ingredients) {
        adding.setName(name);
        adding.setDescription(description);
        adding.setAllItems(ingredients);
    }

    // creating a new item in a pantry
    public DatabaseUpdate(String name, String expire, int quantity, String unit) {
        adding.setName(name);
        adding.setExpdate(expire);
        adding.setQuantity(quantity);
        adding.setUnit(unit);
    }



    //Creates a new item in the pantry
    public void createNewItem() {
        Firebase itemRef = ref.child("Items");
        Firebase itemName = itemRef.child(adding.getName());
        itemName.child("Unit").setValue(adding.getUnit());
        itemName.child("Quantity").setValue(adding.getQuantity());
        itemName.child("Expires").setValue(adding.getExpdate());
    }


    public void createNewRecipe() {
        Firebase recipeRef = ref.child("Recipes");
        Firebase recipeName = recipeRef.child(adding.getName());
        recipeName.child("Ingredients").updateChildren(adding.getAllItems());
        recipeName.child("Description").setValue(adding.getDescription());

    }

    public void createNewGroceryList() {
        Firebase groceryRef = ref.child("Grocery Lists");
        Firebase listName = groceryRef.child(adding.getName());
        listName.child("Items").updateChildren(adding.getAllItems());
        listName.child("Description").setValue(adding.getDescription());
    }

    //update items in a specific recipe
    public void updateRecipe() {
        Firebase recipeRef = ref.child("Recipes");
        Firebase recipeName = recipeRef.child(adding.getName());
        recipeName.child("Ingredients").updateChildren(adding.getAllItems());
        recipeName.child("Description").setValue(adding.getDescription());
    }

    //update items in the pantry
    public void updateItem() {}

    //update items in a specific grocery list
    public void updateGroceryList() {}

}
