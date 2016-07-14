package com.example.zaccianflone.pantrypro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zaccianflone.pantrypro.model.PantryItem;
import com.firebase.client.Firebase;

import java.text.ParseException;

/**
 * Adds an Item to the pantry
 *
 * @author Kylor
 * @version 6/29/2016
 */
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

        boolean addToast = false;

        EditText mName = (EditText) findViewById(R.id.editText6);
        EditText mExpDate = (EditText) findViewById(R.id.editText7);
        EditText mQuantity = (EditText) findViewById(R.id.editText8);
        EditText mUnit = (EditText) findViewById(R.id.editText9);
        EditText mGroup = (EditText) findViewById(R.id.editGroup);

        String name = mName.getText().toString();
        String expDate = mExpDate.getText().toString();
        String quantity = mQuantity.getText().toString();
        String unit = mUnit.getText().toString();
        String group = mGroup.getText().toString();


        Firebase pantryRef = new Firebase ("https://pantrypro-a7109.firebaseio.com/pantry");
        Firebase groupRef = new Firebase ("https://pantrypro-a7109.firebaseio.com/pantryGroup");
        Firebase pushRef = pantryRef.push();

        /*
        This form validation needs to get more robust with better regex validation.  As it stands now,
        this will only write to the firebase if the field isn't empty.

        If the name field is empty, we don't bother testing anything else because we wouldn't want a
        nameless "item"
         */
        if (!name.matches("")){
            //ref.child("pantry").child(name.getText().toString()).child("name").setValue(name.getText().toString());

            addToast = true;

            PantryItem pantryItem = null;
            try {
                pantryItem = new PantryItem(name, expDate, quantity, unit, group);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            /**
             * Adds our pantryItem object to our FireBase
             */
            pushRef.setValue(pantryItem);

            /**
             * this won't add the group if it already exists, but that's exactly what we want: set-like behavior
             */
            groupRef.child(pantryItem.getGroup()).setValue(pantryItem.getGroup());

        }






        // Display toast message at bottom of screen when an item has been added
        if (addToast) {
            Context context = getApplicationContext();
            CharSequence text = "Item added to pantry";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

}
