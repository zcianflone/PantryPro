package com.example.zaccianflone.pantrypro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class AddItemRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_recipe);
    }

    /**
     * When the user clicks back go to Main Activity
     * @param view default param
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, MakeRecipe.class);
        startActivity(intent);
    }

}