package com.example.zaccianflone.pantrypro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.io.IOException;


public class AddItem extends AppCompatActivity {

    private static final String TAG = "AddItem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    /**
     * When the user clicks back go to Main Activity
     * @param view
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * When the user clicks add item, add form to firebase
     * @param view
     */
    public void addItem (View view) {

        EditText name = (EditText) findViewById(R.id.editText6);
        EditText expdate = (EditText) findViewById(R.id.editText7);
        EditText quantity = (EditText) findViewById(R.id.editText8);
        EditText unit = (EditText) findViewById(R.id.editText9);

        Firebase ref=new Firebase ("https://fiery-inferno-4832.firebaseio.com");
        ref.child("pantry").child(name.getText().toString()).child("name").setValue(name.getText().toString());
        ref.child("pantry").child(name.getText().toString()).child("expdate").setValue(expdate.getText().toString());
        ref.child("pantry").child(name.getText().toString()).child("quantity").setValue(quantity.getText().toString());
        ref.child("pantry").child(name.getText().toString()).child("unit").setValue(unit.getText().toString());

        Log.i("Firebase New Item Loc", "pantry>"+name.getText().toString()+">"+"name>"+name.getText().toString());

        // Display toast message at bottom of screen when an item has been added
        Context context = getApplicationContext();
        CharSequence text = "Item added to pantry";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
