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
        // pass in a item
    }

    void comprRecipe() {
        // pass in two recipes for comparing


    }

}

//Test Comment Ben3
//Test Comment Kylor
//Test Comment Ben
//Test comment Kylor2
//test comment ben2