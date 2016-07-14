package com.example.zaccianflone.pantrypro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zaccianflone.pantrypro.model.PantryItem;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.text.ParseException;

public class EditPantryItem extends AppCompatActivity {

    private String mListId, oldGroup;
    private PantryItem mPantryItem;
    Firebase ref, groupRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pantry_item);



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
        groupRef = new Firebase("https://pantrypro-a7109.firebaseio.com/pantryGroup");


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                EditText mName = (EditText) findViewById(R.id.editName);
                EditText mExpDate = (EditText) findViewById(R.id.editExp);
                EditText mQuantity = (EditText) findViewById(R.id.editQuantity);
                EditText mUnit = (EditText) findViewById(R.id.editUnit);
                EditText mGroup = (EditText) findViewById(R.id.editGroup);

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


                mName.setText(mPantryItem.getName(), TextView.BufferType.EDITABLE);
                mExpDate.setText(mPantryItem.getTextExpDate(), TextView.BufferType.EDITABLE);
                mQuantity.setText(mPantryItem.getQuantity(), TextView.BufferType.EDITABLE);
                mUnit.setText(mPantryItem.getUnitType(), TextView.BufferType.EDITABLE);
                mGroup.setText(mPantryItem.getGroup(), TextView.BufferType.EDITABLE);

                oldGroup = mPantryItem.getGroup();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                finish();
                return;
            }
        });





    }

    public void onSubmit(View view){
        EditText mName = (EditText) findViewById(R.id.editName);
        EditText mExpDate = (EditText) findViewById(R.id.editExp);
        EditText mQuantity = (EditText) findViewById(R.id.editQuantity);
        EditText mUnit = (EditText) findViewById(R.id.editUnit);
        EditText mGroup = (EditText) findViewById(R.id.editGroup);

        String newName = mName.getText().toString();
        String newExpDate = mExpDate.getText().toString();
        String newQuantity = mQuantity.getText().toString();
        String newUnit = mUnit.getText().toString();
        String newGroup = mGroup.getText().toString();

        PantryItem pantryItem= null;
        try {
            pantryItem = new PantryItem(newName, newExpDate, newQuantity, newUnit, newGroup);



        } catch (ParseException e) {
            e.printStackTrace();
        }

        ref.setValue(pantryItem);

        groupRef.child(newGroup).setValue(newGroup);




        Intent intent = new Intent(this, PantryListDetails.class);
        intent.putExtra(Constants.KEY_LIST_ID, mListId);

        startActivity(intent);

    }

    public void goBack(View view) {
        Intent intent = new Intent(this, PantryListDetails.class);
        intent.putExtra(Constants.KEY_LIST_ID, mListId);

        startActivity(intent);
    }


}
