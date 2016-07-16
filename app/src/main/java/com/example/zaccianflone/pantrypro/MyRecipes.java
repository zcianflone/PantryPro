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

import com.example.zaccianflone.pantrypro.model.Recipe;
import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

import java.util.ArrayList;

public class MyRecipes extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Firebase ref = new Firebase("https://pantrypro-a7109.firebaseio.com/recipe");
    ArrayList<String> spinList = new ArrayList<String>();
    FirebaseListAdapter<Recipe> fbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipes);
        ListView mListView = (ListView) findViewById(R.id.listView);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> spinAdapter;


        spinList.add("Newest to Oldest");
        spinList.add("Oldest to Newest");
        spinList.add("Alphabetic Order");



        spinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinList);

        // Create an ArrayAdapter using the string array located in strings.xml
       /* ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.viewPantrySpinner, android.R.layout.simple_spinner_item);*/
        // Apply the adapter to the spinner
        spinner.setAdapter(spinAdapter);
        spinner.setOnItemSelectedListener(this);



        mListView.setAdapter(fbAdapter);

        /**
         * This passes the pushID of the clicked item to the PantryListDetails Activity
         */
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Recipe selectedRecipe = fbAdapter.getItem(position);

                if (selectedRecipe != null) {
                    Intent intent = new Intent(MyRecipes.this, RecipeDetail.class);
                    /* Get the list ID using the adapter's get ref method to get the Firebase
                     * ref and then grab the key.
                     */
                    String listId = fbAdapter.getRef(position).getKey();
                    intent.putExtra(Constants.KEY_LIST_ID, listId);
                    /* Starts an active showing the details for the selected list */
                    startActivity(intent);
                }
            }
        });



    }



    /**
     * When the user clicks back go to Main Activity
     * @param view
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        ListView mListView = (ListView) findViewById(R.id.listView);
        TextView myText = (TextView) view;

        if (position == 0) {
            fbAdapter =
                    new FirebaseListAdapter<Recipe>(this, Recipe.class, android.R.layout.simple_list_item_1, ref.orderByChild("invertedTime")) {
                        protected void populateView(View view, Recipe recipe, int position) {
                            TextView textView = (TextView) view.findViewById(android.R.id.text1);
                            textView.setText(recipe.getName());
                        }
                    };

        }

        else if (position == 1) {
            fbAdapter =
                    new FirebaseListAdapter<Recipe>(this, Recipe.class, android.R.layout.simple_list_item_1, ref) {
                        protected void populateView(View view, Recipe recipe, int position) {
                            TextView textView = (TextView) view.findViewById(android.R.id.text1);
                            textView.setText(recipe.getName());
                        }
                    };

        }

        else if (position == 2) {
            fbAdapter =
                    new FirebaseListAdapter<Recipe>(this, Recipe.class, android.R.layout.simple_list_item_1, ref.orderByChild("name")) {
                        protected void populateView(View view, Recipe recipe, int position) {
                            TextView textView = (TextView) view.findViewById(android.R.id.text1);
                            textView.setText(recipe.getName());
                        }
                    };

        }


        Toast.makeText(this, "You Selected " +myText.getText(), Toast.LENGTH_SHORT).show();

        fbAdapter.notifyDataSetChanged();
        mListView.setAdapter(fbAdapter);



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}

