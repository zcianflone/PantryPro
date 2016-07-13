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

public class EditPantryItem extends AppCompatActivity {

    private String mListId;
    private PantryItem mPantryItem;
    Firebase ref;



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


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                EditText mName = (EditText) findViewById(R.id.editName);
                EditText mExpDate = (EditText) findViewById(R.id.editExp);
                EditText mQuantity = (EditText) findViewById(R.id.editQuantity);
                EditText mUnit = (EditText) findViewById(R.id.editUnit);

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
                mExpDate.setText(mPantryItem.getExpDate(), TextView.BufferType.EDITABLE);
                mQuantity.setText(mPantryItem.getQuantity(), TextView.BufferType.EDITABLE);
                mUnit.setText(mPantryItem.getUnitType(), TextView.BufferType.EDITABLE);
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

        String newName = mName.getText().toString();
        String newExpDate = mExpDate.getText().toString();
        String newQuantity = mQuantity.getText().toString();
        String newUnit = mUnit.getText().toString();

        PantryItem pantryItem= new PantryItem(newName, newExpDate, newQuantity, newUnit);

        ref.setValue(pantryItem);

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
