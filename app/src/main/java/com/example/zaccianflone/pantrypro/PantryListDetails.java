package com.example.zaccianflone.pantrypro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.zaccianflone.pantrypro.model.PantryItem;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class PantryListDetails extends AppCompatActivity {

    private String mListId;
    private PantryItem mPantryItem;
    ArrayList<String> PantryList = new ArrayList<String>();
    Firebase ref;
    ArrayAdapter<String> arrayAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_list_details);

        ListView mListView = (ListView) findViewById(R.id.listView);

         /* Get the push ID from the extra passed by View Pantry */
        Intent intent = this.getIntent();
        mListId = intent.getStringExtra(Constants.KEY_LIST_ID);

        Log.d("PantryListDetails", mListId);
        if (mListId == null) {
            /* No point in continuing without a valid ID. */
            return;
        }

        /**
         * Create Firebase reference
         */
       ref = new Firebase("https://pantrypro-a7109.firebaseio.com/pantry").child(mListId);


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                /**
                 * Saving the most recent version of current shopping list into mShoppingList if present
                 * finish() the activity if the list is null (list was removed or unshared by it's owner
                 * while current user is in the list details activity)
                 */
                PantryItem pantryItem = snapshot.getValue(PantryItem.class);

                if (pantryItem == null) {
                    finish();
                    /**
                     * Make sure to call return, otherwise the rest of the method will execute,
                     * even after calling finish.
                     */
                    return;
                }

                mPantryItem = pantryItem;


                Log.d("Hi", mPantryItem.getName());
                PantryList.add("Name: " + mPantryItem.getName());
                PantryList.add("Quantity: " + mPantryItem.getQuantity());
                PantryList.add("Expiration Date: " + mPantryItem.getTextExpDate());
                PantryList.add("Unit Type: " + mPantryItem.getUnitType());
                PantryList.add("Group: " + mPantryItem.getGroup());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                finish();
                return;
            }
        });



        arrayAdapter = new ArrayAdapter<String>(this,
                                                                    android.R.layout.simple_list_item_1,
                                                                    PantryList);

       mListView.setAdapter(arrayAdapter);

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

    /**
     * When the user clicks back go to Main Activity
     * @param view
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, ViewPantry.class);
        startActivity(intent);
    }
}
