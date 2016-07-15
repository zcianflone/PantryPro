package com.example.zaccianflone.pantrypro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zaccianflone.pantrypro.database.Create;
import com.example.zaccianflone.pantrypro.model.PantryItem;
import com.example.zaccianflone.pantrypro.pantry.Item;
import com.example.zaccianflone.pantrypro.pantry.Pantry;
import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Adds an Item to the pantry
 *
 * @author Kylor
 * @version 6/29/2016
 */
public class AddItem extends AppCompatActivity {

    //private static final String TAG = "AddItem";
    private EditText mName, mExpDate, mQuantity, mUnit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void run(View view) {

        mName = (EditText) findViewById(R.id.editText6);
        mExpDate = (EditText) findViewById(R.id.editText7);
        mQuantity = (EditText) findViewById(R.id.editText8);
        mUnit = (EditText) findViewById(R.id.editText9);

//        name = mName.getText().toString();
//        expDate = mExpDate.getText().toString();
//        quantity = mQuantity.getText().toString();
//        unit = mUnit.getText().toString();

        if (!checkFields()) {
            return;
        }

        addItem();
        clearFields();
        toast(view);
    }


    private Boolean checkFields() {
        if (!Constants.checkFields(mName)) {
            Toast.makeText(this, "No name for the Item", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!Constants.checkFields(mExpDate)) {
            Toast.makeText(this, "No name for the Expiration Date", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!Constants.checkFields(mQuantity)) {
            Toast.makeText(this, "No value for the Quantity", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!Constants.checkFields(mUnit)) {
            Toast.makeText(this, "No value for the Quantity", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }

    private void clearFields() {
        mName.getText().clear();
        mExpDate.getText().clear();
        mQuantity.getText().clear();
        mUnit.getText().clear();
    }

    public void toast(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Item added to pantry";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void addItem() {

        //boolean addToast = false;

//        EditText mName = (EditText) findViewById(R.id.editText6);
//        EditText mExpDate = (EditText) findViewById(R.id.editText7);
//        EditText mQuantity = (EditText) findViewById(R.id.editText8);
//        EditText mUnit = (EditText) findViewById(R.id.editText9);

//        /*String*/ name = mName.getText().toString();
//        /*String*/ expDate = mExpDate.getText().toString();
//        /*String*/ quantity = mQuantity.getText().toString();
//        /*String*/ unit = mUnit.getText().toString();

        List<String> list = new ArrayList<>();
        list.add(mName.getText().toString());
        list.add(mExpDate.getText().toString());
        list.add(mQuantity.getText().toString());
        list.add(mUnit.getText().toString());

        Pantry item = new Item();
        item.addOrEdit(list);






//        Firebase pantryRef = new Firebase ("https://pantrypro-a7109.firebaseio.com/pantry");
//        Firebase pushRef = pantryRef.push();
//
//        /*
//        This form validation needs to get more robust with better regex validation.  As it stands now,
//        this will only write to the firebase if the field isn't empty.
//
//        If the name field is empty, we don't bother testing anything else because we wouldn't want a
//        nameless "item"
//         */
//        if (!name.matches("")){
//            //ref.child("pantry").child(name.getText().toString()).child("name").setValue(name.getText().toString());
//
//            addToast = true;
//
//           /* if (!expdate.getText().toString().matches("")){
//                //ref.child("pantry").child(name.getText().toString()).child("expdate").setValue(expdate.getText().toString());
//            }*/
//
//            if (!quantity.matches("")){
//                //ref.child("pantry").child(name.getText().toString()).child("quantity").setValue(quantity.getText().toString());
//            }
//            else //if the user doesn't specify a quantity, we default a quantity of 1
//            {
//                //ref.child("pantry").child(name.getText().toString()).child("quantity").setValue("1");
//            }
//
//            /*if (!unit.getText().toString().matches("")){
//                //ref.child("pantry").child(name.getText().toString()).child("unit").setValue(unit.getText().toString());
//            }*/
//
//            PantryItem pantryItem = new PantryItem(name, expDate, quantity, unit);
//
//            pushRef.setValue(pantryItem);
//
//        }
//



//        // Display toast message at bottom of screen when an item has been added
//        if (addToast) {
//            Context context = getApplicationContext();
//            CharSequence text = "Item added to pantry";
//            int duration = Toast.LENGTH_SHORT;
//            Toast toast = Toast.makeText(context, text, duration);
//            toast.show();
//        }
    }

}
