package com.example.zaccianflone.pantrypro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

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

        Firebase ref = new Firebase("https://pantrypro-a7109.firebaseio.com/message");

        FirebaseListAdapter<String> fbAdapter =
                new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_list_item_1, ref) {
                    @Override
                    protected void populateView(View view, String s, int position) {
                        TextView textView = (TextView)view.findViewById(android.R.id.text1);
                        textView.setText(s);
                    }
                };
        //Firebase.getDefaultConfig().setLogLevel(Logger.Level.DEBUG);

        mListView.setAdapter(fbAdapter);

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

