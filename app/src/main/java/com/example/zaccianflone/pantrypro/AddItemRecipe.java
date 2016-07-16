package com.example.zaccianflone.pantrypro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zaccianflone.pantrypro.model.PantryItem;
import com.example.zaccianflone.pantrypro.model.Recipe;
import com.firebase.client.Firebase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class AddItemRecipe extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private String name, directions, item;
    private EditText ingredient, quantity, units;

    private ArrayList<String> ingredients = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_recipe);

        // Retrieve info passed from RecipeName activity
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        directions = intent.getStringExtra("directions");

    }

    /*
     * Called when user clicks back
     * Takes user to MainActivity
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /*
     * Called when user clicks Finish button
     * Submits recipe with all of the current ingredients to the firebase
     */
    public void finish(View view) {
        // Make sure ingredients have been added
        if (ingredients.size() == 0){
            Toast.makeText(this, "Add at least one ingredient", Toast.LENGTH_SHORT).show();
        }
        else {
            Recipe recipe = null;
            try {
                recipe = new Recipe(name, directions, ingredients);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            // Send recipe to firebase
            Firebase pantryRef = new Firebase ("https://pantrypro-a7109.firebaseio.com/recipe");
            Firebase pushRef = pantryRef.push();
            pushRef.setValue(recipe);

            Toast.makeText(this, "Recipe added", Toast.LENGTH_SHORT).show();

            // This will take the user back to MainActivity
            goBack(view);
        }
    }

    /*
     * Called whenever the user clicks add
     * Adds an ingredient to the arraylist
     */
    public void addItem(View view) {
        ingredient = (EditText) findViewById(R.id.editText6);

        if (!Constants.checkFields(ingredient)) {
            Toast.makeText(this, "No name for the ingredient", Toast.LENGTH_SHORT).show();
        }
        else {
            item = ingredient.getText().toString();
            ingredients.add(item);
            toast(view);
            clearFields();
        }
    }

    /*
     * Clear all text fields
     */
    private void clearFields() {
        ingredient.getText().clear();
        quantity = (EditText) findViewById(R.id.editText8);
        quantity.setText("");
        units = (EditText) findViewById(R.id.editText9);
        units.setText("");
    }

    /*
     * Display item added toast
     */
    public void toast(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Item added to Recipe";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}