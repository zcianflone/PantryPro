package com.example.zaccianflone.pantrypro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RecipeName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_name);
    }

    public void goToMakeRecipe(View view) {
        Intent intent = new Intent(this, MakeRecipe.class);
        startActivity(intent);
    }

    /**
     * When the user clicks back go to Main Activity
     * @param view
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
