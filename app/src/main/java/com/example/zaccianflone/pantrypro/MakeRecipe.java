package com.example.zaccianflone.pantrypro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Takes user items to form a recipe
 *
 * @author kylor
 * @version 6/29/2016
 */
public class MakeRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_recipe);


    }

    /**
     * When the user clicks back go to Main Activity
     * @param view
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
/*
   public Boolean checkFields(View view) {
        EditText nameOfRecipe = (EditText) findViewById(R.id.name_recipe);
        EditText description = (EditText) findViewById(R.id.description);

        if (nameOfRecipe == null) {
            return false;
        }
        else if (description == null) {
            return false;
        }
        else {
            goToAddItemRecipe(view);
            return true;
        }
    }
*/

    /**
     * When the user clicks Add Item go to Add Item to Recipe
     * @param view default parameter
     */
    public void goToAddItemRecipe(View view) {
        Intent intent = new Intent(this, AddItemRecipe.class);
/*
        EditText nameOfRecipe = (EditText) findViewById(R.id.name_recipe);
        String name = nameOfRecipe.getText().toString();

        EditText description = (EditText) findViewById(R.id.description);
        String info = description.getText().toString();

        intent.putExtra("name", name);
        intent.putExtra("info", info);
*/
        startActivity(intent);
    }
}
