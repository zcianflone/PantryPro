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

import com.example.zaccianflone.pantrypro.model.PantryItem;
import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

public class ViewPantry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pantry);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array located in strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.viewPantrySpinner, android.R.layout.simple_spinner_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        ListView mListView = (ListView) findViewById(R.id.listView);

        Firebase ref = new Firebase("https://pantrypro-a7109.firebaseio.com/pantry");

        final FirebaseListAdapter<PantryItem> fbAdapter =
                new FirebaseListAdapter<PantryItem>(this, PantryItem.class, android.R.layout.simple_list_item_1, ref) {
                    @Override
                    protected void populateView(View view, PantryItem pantryItem, int position) {
                        TextView textView = (TextView)view.findViewById(android.R.id.text1);


                        textView.setText(pantryItem.getName() + " " + pantryItem.getQuantity());
                    }
                };
        mListView.setAdapter(fbAdapter);

       mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PantryItem selectedItem = fbAdapter.getItem(position);

                if (selectedItem != null) {
                    Intent intent = new Intent(ViewPantry.this, PantryListDetails.class);
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
}

