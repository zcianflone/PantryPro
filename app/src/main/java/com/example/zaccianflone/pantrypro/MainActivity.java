package com.example.zaccianflone.pantrypro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Log.d(TAG, "onCreate() Restoring previous state");
            /* restore state */
        } else {
            Log.d(TAG, "onCreate() No saved state available");
            /* initialize app */
        }

        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);

        setContentView(R.layout.activity_main);

    }

    /**
     * When the user clicks "Add Item" go to Add Item page
     * @param view default parameter
     */
    public void goToAddItem(View view) {
        Intent intent = new Intent(this, AddItem.class);
        startActivity(intent);
    }

    /**
     * When the user clicks "View Pantry" go to View Pantry page
     * @param view default parameter
     */
    public void goToViewPantry(View view) {
        Intent intent = new Intent(this, ViewPantry.class);
        startActivity(intent);
    }

    /**
     * When the user clicks "Make Recipe" go to Make Recipe page
     * @param view default parameter
     */
    public void goToMakeRecipe(View view) {
        Intent intent = new Intent(this, RecipeName.class);
        startActivity(intent);
    }

    /**
     * When the user clicks "My Recipes" go to My Recipes page
     * @param view default parameter
     */
    public void goToMyRecipes(View view) {
        Intent intent = new Intent(this, MyRecipes.class);
        startActivity(intent);
    }

    /**
     * When the user clicks "Make Recipe" go to Recipe Name page
     * @param view default parameter
     */
    public void goToRecipeName(View view) {
        Intent intent = new Intent(this, RecipeName.class);
        startActivity(intent);
    }

}


