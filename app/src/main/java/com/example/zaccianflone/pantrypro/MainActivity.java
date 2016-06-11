package com.example.zaccianflone.pantrypro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ShoppingList shop = new ShoppingList();

        Pantry pantry=new Pantry();
        pantry.testAdd();

    }

    // When the user clicks add item go to add item page
    public void goToAddItem(View view) {
        Intent intent = new Intent(this, AddItem.class);
        startActivity(intent);
    }

}

class Pantry {
    protected ArrayList<Item> item;
    private String name;
    private String date;
    private int quantity;
    private String expiration;

    void add(){

    }

    void testAdd(){
        // Add a new item to the pantry
        Item test = null;

        assert (name.length() != 0);
        assert (date.length() != 0);
        assert (date.length() <= 30);
        assert (quantity > 0);
        assert (quantity <= 10000);
        assert (expiration.length() != 0);
        assert (expiration.length() <= 1000);

        assert(item.add(test));


    }

    void delete(){

    }

    void testDelete(){
        // Delete an item from the pantry
        Item test = null;
        assert(item.remove(test));
    }

}


class Recipe {

    protected ArrayList<Item> ingredients;
    private String name;


    //This method should create new recipe
    void CreateRecipe (){


    }

    //This method should add ingredients to existing recipe
    void EditRecipe (){

    }



    void testCreate () {
        assert (!ingredients.isEmpty());
        assert (ingredients.size() <= 10000);//tests for corruption by limiting size to arbitrary amount
        assert (name.length() != 0);
        assert (name.length() <= 1000);
    }


    void testEdit() {
        Item test=null;
        assert(ingredients.add(test));      //tests add
        assert(ingredients.remove(test)); //removes
    }


}

class Item {

}

// commit by Ben Wright 6/7/16
class ShoppingList {

    String name;
    int numItems;
    protected ArrayList<Item> ShoppingList;
    ShoppingList(){}


    // it will be a good idea for addToPantry to be overloaded
    // that way you can have one that handles a recipe and the other a item

    void testShoppingList (){
        assert(name.length() != 0);
        assert(name.length() <= 1000);
        assert (numItems <= 1000);
    }

    void testAddToShoppingList (){
        Item test=null;
        assert (ShoppingList.add(test));
        assert (ShoppingList.remove(test));

    }

    // overload 1
    void addToPantry(Recipe recipe){
        //pass in a recipe

        // Create a new row in the Recipe Table for the recipe

        // Add in the recipe with its other values (parameters if any)

        // complete recipe update.

    }

    // overload 2
    void addToPantry(Item item, String expiration) {
        // pass in a item

        // Create a new row in the item table

        // Add in the item with its expiration date

        // Complete item update
    }

    // compare a recipe to another
    void comprRecipe() {
        // pass in two recipes for comparing


    }

}