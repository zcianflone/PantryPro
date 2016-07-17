package com.example.zaccianflone.pantrypro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zaccianflone.pantrypro.model.Ingredient;
import com.example.zaccianflone.pantrypro.model.Recipe;
import com.firebase.client.Firebase;

import java.text.ParseException;

public class AddItemRecipe extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private String recipeName, directions, item;
    private EditText ingredient, quantity, units;

    Firebase ingredientRef;
    Firebase pushIngredient;

    Firebase recipeRef = new Firebase ("https://pantrypro-a7109.firebaseio.com/recipe");
    Firebase pushRef = recipeRef.push();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_recipe);


        // Retrieve info passed from RecipeName activity
        Intent intent = getIntent();
        recipeName = intent.getStringExtra("recipeName");
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

            Recipe recipe = null;

            try {
                recipe = new Recipe(recipeName, directions);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            // Send recipe to firebase

            pushRef.setValue(recipe);

            Toast.makeText(this, "Recipe added", Toast.LENGTH_SHORT).show();

            // This will take the user back to MainActivity
            goBack(view);
        }


    /*
     * Called whenever the user clicks add
     * Adds an ingredient to the arraylist
     */
    public void addItem(View view) {

        /*if (!Constants.checkFields(mName)) {
            Toast.makeText(this, "No name for the ingredient", Toast.LENGTH_SHORT).show();
        }
        else {*/

        EditText mName;
        EditText mQuantity;
        EditText mUnit;
        String ingredientName;
        String ingredientQuantity;
        String ingredientUnit;
        ingredientRef = new Firebase("https://pantrypro-a7109.firebaseio.com/ingredients");
        pushIngredient = ingredientRef.push();


        mName = (EditText) findViewById(R.id.editName);
            mQuantity = (EditText) findViewById(R.id.editQuantity);
            mUnit = (EditText) findViewById(R.id.editUnits);

            ingredientName = mName.getText().toString();
            ingredientQuantity = mQuantity.getText().toString();
            ingredientUnit = mUnit.getText().toString();

        Log.d("Name", ingredientName);
        Log.d("Quant", ingredientQuantity);
        Log.d("Unit", ingredientUnit);

        Ingredient ingredient = new Ingredient(recipeName, ingredientName, ingredientQuantity, ingredientUnit);
        pushIngredient.setValue(ingredient);
            toast(view);
            clearFields();
        //}
    }

    /*
     * Clear all text fields
     */
    private void clearFields() {
        ingredient = (EditText) findViewById(R.id.editName);
        ingredient.getText().clear();
        quantity = (EditText) findViewById(R.id.editQuantity);
        quantity.setText("");
        units = (EditText) findViewById(R.id.editUnits);
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