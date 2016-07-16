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
import com.example.zaccianflone.pantrypro.pantry.Item;
import com.example.zaccianflone.pantrypro.pantry.Pantry;
import com.example.zaccianflone.pantrypro.pantry.Recipe;
import com.firebase.client.Firebase;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddItemRecipe extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private static String name, directions;
    private static EditText ingredient, quantity, units;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_recipe);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        directions = intent.getStringExtra("directions");

    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void run(View view) {
        ingredient = (EditText) findViewById(R.id.editText6);
        quantity = (EditText) findViewById(R.id.editText8);
        units = (EditText) findViewById(R.id.editText9);

        if (!checkFields()) {
            return;
        }

        addItem(view);
        clearFields();
        toast(view);
    }

    private Boolean checkFields() {
        if (!Constants.checkFields(ingredient)) {
            Toast.makeText(this, "No name for the ingredient", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!Constants.checkFields(quantity)) {
            Toast.makeText(this, "No amount given", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!Constants.checkFields(units)) {
            Toast.makeText(this, "No given unit", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }


    public void addItem(View view) {

        List<String> items = new ArrayList<>();
        items.add(name);
        items.add(directions);
        items.add(ingredient.getText().toString());
        items.add(quantity.getText().toString());
        items.add(units.getText().toString());

        Pantry item = new Recipe();
        item.addOrEdit(items);
    }


    private void clearFields() {
        ingredient.getText().clear();
        quantity.getText().clear();
        units.getText().clear();
    }

    public void toast(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Item added to Recipe";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}