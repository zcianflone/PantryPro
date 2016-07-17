package com.example.zaccianflone.pantrypro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.zaccianflone.pantrypro.model.Recipe;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class GenerateList extends AppCompatActivity {

    // Variables used to pull the recipe info
    private String mListId;
    private Recipe mRecipe;
    ArrayList<String> RecipeList = new ArrayList<String>();
    Firebase ref;
    ArrayAdapter<String> arrayAdapter;

    // Variables used to pull the pantry
    Firebase refP = new Firebase("https://pantrypro-a7109.firebaseio.com/pantry");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_list_details);

        ListView mListView = (ListView) findViewById(R.id.listView);

         /* Get the push ID from the extra passed by View Pantry */
        Intent intent = this.getIntent();
        mListId = intent.getStringExtra(Constants.KEY_LIST_ID);

        Log.d("RecipeDetail", mListId);
        if (mListId == null) {
            /* No point in continuing without a valid ID. */
            return;
        }

        /**
         * Create Firebase reference
         */
        ref = new Firebase("https://pantrypro-a7109.firebaseio.com/recipe").child(mListId);


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                /**
                 * Saving the most recent version of current shopping list into mShoppingList if present
                 * finish() the activity if the list is null (list was removed or unshared by it's owner
                 * while current user is in the list details activity)
                 */
                Recipe recipe = snapshot.getValue(Recipe.class);

                if (recipe == null) {
                    finish();
                    /**
                     * Make sure to call return, otherwise the rest of the method will execute,
                     * even after calling finish.
                     */
                    return;
                }

                mRecipe = recipe;

                Log.d("Hi", mRecipe.getName());
                //RecipeList = (mRecipe.getIngredients());

                generateList();


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                finish();
                return;
            }
        });

        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                RecipeList);

        mListView.setAdapter(arrayAdapter);

    }

    public void generateList(){

    }

    /**
     * When the user clicks back go to Main Activity
     * @param view
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, ViewPantry.class);
        startActivity(intent);
    }
}
