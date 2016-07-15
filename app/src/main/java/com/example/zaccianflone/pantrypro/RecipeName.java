package com.example.zaccianflone.pantrypro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RecipeName extends AppCompatActivity {
    private EditText name, directions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_name);
        //name.getText().clear();
        //directions.getText().clear();
    }

    public void goToMakeRecipe(View view) {
        //Intent intent = new Intent(this, MakeRecipe.class);
        Intent intent = new Intent(this, AddItemRecipe.class);

        name = (EditText) findViewById(R.id.editText11);
        directions = (EditText) findViewById(R.id.editText);

        if (!checkFields()) {
            return;
        }

        intent.putExtra("name", name.getText().toString());
        intent.putExtra("directions", directions.getText().toString());


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

    private Boolean checkFields() {
        if (!Constants.checkFields(name)) {
            Toast.makeText(this, "Please type a name for the recipe", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!Constants.checkFields(directions)) {
            Toast.makeText(this, "Please write directions for your recipe", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }
}
