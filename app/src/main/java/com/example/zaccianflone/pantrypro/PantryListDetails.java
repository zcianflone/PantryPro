package com.example.zaccianflone.pantrypro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.firebase.client.Firebase;

public class PantryListDetails extends AppCompatActivity {

    private String mListId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_list_details);

        ListView mListView = (ListView) findViewById(R.id.listView);

         /* Get the push ID from the extra passed by View Pantry */
        Intent intent = this.getIntent();
        mListId = intent.getStringExtra(Constants.KEY_LIST_ID);
        if (mListId == null) {
            /* No point in continuing without a valid ID. */
            finish();
            return;


        }

        /**
         * Create Firebase reference
         */
        Firebase ref = new Firebase("https://pantrypro-a7109.firebaseio.com/pantry").child(mListId);

        /**
         * Setup the adapter

        ActiveListItemAdapter mActiveListItemAdapter = new ActiveListItemAdapter(this, ShoppingListItem.class,
                R.layout.single_active_list_item, listItemsRef.orderByChild(Constants.FIREBASE_PROPERTY_BOUGHT_BY),
                mListId, mEncodedEmail);
        // Create ActiveListItemAdapter and set to listView
        mListView.setAdapter(mActiveListItemAdapter);
        */
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
