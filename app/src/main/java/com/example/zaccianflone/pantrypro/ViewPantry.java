package com.example.zaccianflone.pantrypro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zaccianflone.pantrypro.model.PantryItem;
import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

public class ViewPantry extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Firebase ref = new Firebase("https://pantrypro-a7109.firebaseio.com/pantry");

    FirebaseListAdapter<PantryItem> fbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pantry);
        ListView mListView = (ListView) findViewById(R.id.listView);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array located in strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.viewPantrySpinner, android.R.layout.simple_spinner_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



        mListView.setAdapter(fbAdapter);

        /**
         * This passes the pushID of the clicked item to the PantryListDetails Activity
         */
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        ListView mListView = (ListView) findViewById(R.id.listView);
        TextView myText = (TextView) view;

        Log.d("in item selected", myText.getText().toString() );

        if (position == 1) {
            fbAdapter =
                    new FirebaseListAdapter<PantryItem>(this, PantryItem.class, android.R.layout.simple_list_item_1, ref) {
                        @Override
                        protected void populateView(View view, PantryItem pantryItem, int position) {
                            TextView textView = (TextView) view.findViewById(android.R.id.text1);


                            textView.setText(pantryItem.getName());
                        }
                    };

        }
        else if (position == 2)
        {
            fbAdapter =
                    new FirebaseListAdapter<PantryItem>(this, PantryItem.class, android.R.layout.simple_list_item_1, ref.orderByChild("name")) {
                        @Override
                        protected void populateView(View view, PantryItem pantryItem, int position) {
                            TextView textView = (TextView)view.findViewById(android.R.id.text1);


                            textView.setText(pantryItem.getName());
                        }
                    };
        }

        else if (position == 3)
        {
            fbAdapter =
                    new FirebaseListAdapter<PantryItem>(this, PantryItem.class, android.R.layout.simple_list_item_1, ref.orderByChild("expDate")) {
                        @Override
                        protected void populateView(View view, PantryItem pantryItem, int position) {
                            TextView textView = (TextView)view.findViewById(android.R.id.text1);


                            textView.setText(pantryItem.getName() +"    Exp: "+ pantryItem.getExpDate());
                        }
                    };
        }

        else{
            fbAdapter =
                    new FirebaseListAdapter<PantryItem>(this, PantryItem.class, android.R.layout.simple_list_item_1, ref.orderByChild("invertedTime")) {
                        @Override
                        protected void populateView(View view, PantryItem pantryItem, int position) {
                            TextView textView = (TextView)view.findViewById(android.R.id.text1);


                            textView.setText(pantryItem.getName());
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

