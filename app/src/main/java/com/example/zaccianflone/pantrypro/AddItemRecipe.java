package com.example.zaccianflone.pantrypro;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Pair;

import com.example.zaccianflone.pantrypro.database.Adding;
import com.example.zaccianflone.pantrypro.database.Create;
import com.example.zaccianflone.pantrypro.database.DatabaseUpdate;
import com.firebase.client.Firebase;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddItemRecipe extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    private static String recipeName;
    private static String info;
    private static Firebase ref = new Firebase(Constants.FIREBASE_URL);
    //private HashMap<String, Object> itemList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_recipe);

        //Intent intent = getIntent();
        //recipeName = intent.getStringExtra("name");
        //info = intent.getStringExtra("info");


    }

    /**
     * When the user clicks back go to Main Activity
     *
     * @param view
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, MakeRecipe.class);
        startActivity(intent);
    }


    public void addItem(View view) {

        try {

            EditText name = (EditText) findViewById(R.id.editText6);
            String itemName = name.getText().toString();

            EditText quantity = (EditText) findViewById(R.id.editText8);

            String amount = quantity.getText().toString();
            //int amount = Integer.parseInt(quantity.getText().toString());

            EditText unit = (EditText) findViewById(R.id.editText9);
            String unitType = unit.getText().toString();

            //Create create = new Create();
            //create.execute();

            //ref.child("Recipes").child(recipeName).child(itemName).child("Quantity").setValue(amount);
            //ref.child("Recipes").child(recipeName).child(itemName).child("Unit").setValue(unitType);


        }

        catch(NullPointerException error) {
            error.printStackTrace();
        }



    }

    public void finish(View view) {
        //DatabaseUpdate fireBase = new DatabaseUpdate(recipeName, info, itemList);
        //fireBase.createNewRecipe();


        Intent intent = new Intent(this, MakeRecipe.class);
        startActivity(intent);

    }
}