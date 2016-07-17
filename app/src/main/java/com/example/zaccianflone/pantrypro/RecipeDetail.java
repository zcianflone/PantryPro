package com.example.zaccianflone.pantrypro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zaccianflone.pantrypro.model.Ingredient;
import com.example.zaccianflone.pantrypro.model.Recipe;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.FirebaseListAdapter;

import java.util.ArrayList;

public class RecipeDetail extends AppCompatActivity {

    private String mListId, recipeName;
    private Recipe mRecipe;

    Firebase ref;
    Firebase ingredientRef;
    ArrayAdapter<String> arrayAdapter;
    FirebaseListAdapter<Ingredient> fbAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        ListView mListView = (ListView) findViewById(R.id.listView);

         /* Get the push ID from the extra passed by View Pantry */
        Intent intent = this.getIntent();
        mListId = intent.getStringExtra(Constants.KEY_LIST_ID);
        recipeName = intent.getStringExtra("recipeName");

        Log.d("RecipeDetail", mListId);
        if (mListId == null) {
            /* No point in continuing without a valid ID. */
            return;
        }

        /**
         * Create Firebase reference
         */
        ref = new Firebase("https://pantrypro-a7109.firebaseio.com/recipe").child(mListId);

       /* fbAdapter =
                new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_list_item_1, ref) {
                    protected void populateView(View view, Recipe recipe, int position) {
                        TextView textView = (TextView) view.findViewById(android.R.id.text1);
                        textView.setText(recipe.getName());
                    }
                };*/

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
                recipeName = mRecipe.getName();

                Log.d("Hi", mRecipe.getName());

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                finish();
                return;
            }


        });


       ingredientRef = new Firebase("https://pantrypro-a7109.firebaseio.com/ingredients");

        fbAdapter =
                new FirebaseListAdapter<Ingredient>(this, Ingredient.class, android.R.layout.simple_list_item_1, ingredientRef.orderByChild("recipeName").equalTo(recipeName)) {
                    protected void populateView(View view, Ingredient ingredient, int position) {
                        TextView textView = (TextView) view.findViewById(android.R.id.text1);
                        textView.setText(ingredient.getName());
                    }
                };

        fbAdapter.notifyDataSetChanged();
        mListView.setAdapter(fbAdapter);

        //Log.d("recipe name", recipeName);



    }

    public void remove(View view){
        ref.removeValue();
        Intent intent = new Intent(this, ViewPantry.class);
        startActivity(intent);
    }

    public void goEdit(View view){
        Intent intent = new Intent(this, EditPantryItem.class);
        intent.putExtra(Constants.KEY_LIST_ID, mListId);
        arrayAdapter.clear();

        startActivity(intent);
    }

    public void goGenerateList(View view){
        Intent intent = new Intent(RecipeDetail.this, GenerateList.class);
        intent.putExtra(Constants.KEY_LIST_ID, mListId);
        startActivity(intent);
    }
    /**
     * When the user clicks back go to Main Activity
     * @param view
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, MyRecipes.class);
        startActivity(intent);
    }
}
