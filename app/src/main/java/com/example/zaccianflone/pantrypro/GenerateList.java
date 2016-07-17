package com.example.zaccianflone.pantrypro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class GenerateList extends AppCompatActivity {

    /**
     * When the user clicks back go to Main Activity
     *
     * @param view
     */

    Firebase ingredientRef, pantryRef;
    String recipeName;
    ArrayList<String> recipeIngredients = new ArrayList<String>();
    ArrayList<String> pantryIngredients = new ArrayList<String>();
    ArrayList<String> neededIngredients = new ArrayList<String>();
    ArrayAdapter<String> arrayAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_list);

        ListView mListView = (ListView) findViewById(R.id.listView);

        Intent intent = this.getIntent();
        recipeName = intent.getStringExtra("recipeName");

        ingredientRef = new Firebase("https://pantrypro-a7109.firebaseio.com/ingredients");
        pantryRef = new Firebase("https://pantrypro-a7109.firebaseio.com/pantry");

        ingredientRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot child : snapshot.getChildren()) {

                    String name = (String) child.child("recipeName").getValue();
                    String item = (String) child.child("name").getValue();

                   // Log.d("ingred name", name);
                    //Log.d("recipe name", recipeName);

                    if (name.equals(recipeName)){
                        recipeIngredients.add(item);

                        //Log.d("inside g", recipeName);

                        for (String items : recipeIngredients){
                           // Log.d("items 1", items);
                        }


                    }

                }
            }


            @Override
            public void onCancelled(FirebaseError firebaseError) {
                finish();
                return;
            }
        });

        pantryRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot child : snapshot.getChildren()) {

                    String item = (String) child.child("name").getValue();

                    pantryIngredients.add(item);

                }

                for (String items : recipeIngredients) {
                    if (!pantryIngredients.contains(items)) {

                        neededIngredients.add(items);
                    }
                }






            }


            @Override
            public void onCancelled(FirebaseError firebaseError) {
                finish();
                return;
            }
        });




        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                neededIngredients);

        mListView.setAdapter(arrayAdapter);


    }




    public void goBack(View view) {
        Intent intent = new Intent(this, ViewPantry.class);
        startActivity(intent);
    }

}

