package com.example.zaccianflone.pantrypro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ShoppingList shop = new ShoppingList();

    }

}

class pantry {
    void add(){
        // Add a new item to the pantry
    }

    void delete(){
        // Delete an item from the pantry
    }

}

class Recipe {

}

class Item {

}

class ShoppingList {
    ShoppingList(){}

    // overload 1
    void addToPantry(Recipe recipe){
        //pass in a recipe

    }

    // overload 2
    void addToPantry(Item item) {
        // pass in an item
    }

    void comprRecipe() {
        // pass in two recipes for comparing


    }

}