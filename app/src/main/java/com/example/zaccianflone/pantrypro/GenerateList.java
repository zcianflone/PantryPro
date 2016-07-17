package com.example.zaccianflone.pantrypro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zaccianflone.pantrypro.model.Ingredient;
import com.example.zaccianflone.pantrypro.model.Recipe;
import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

import java.util.ArrayList;

public class GenerateList extends AppCompatActivity {

    String mListId, recipeName;
    Recipe mRecipe;

    ArrayAdapter<String> arrayAdapter;
    ListView mListView = (ListView) findViewById(R.id.listView);

    Firebase refI = new Firebase("https://pantrypro-a7109.firebaseio.com/ingredients");
    Firebase refP = new Firebase("https://pantrypro-a7109.firebaseio.com/pantry");
    ArrayList<String> ingredients = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipes);

        /* Get the push ID from the extra passed by View Pantry */
        Intent intent = this.getIntent();
        recipeName = intent.getStringExtra("recipeName");





    }



    /**
     * When the user clicks back go to Main Activity
     * @param view
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, RecipeDetail.class);
        startActivity(intent);
    }
}

