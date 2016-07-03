package com.example.zaccianflone.pantrypro;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class AddItemRecipe extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_recipe);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * When the user clicks back go to Main Activity
     *
     * @param view
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, MakeRecipe.class);
        startActivity(intent);
    }


    public void addItem(View view) {

        boolean addToast = false;

        EditText name = (EditText) findViewById(R.id.editText6);
        EditText quantity = (EditText) findViewById(R.id.editText8);
        EditText unit = (EditText) findViewById(R.id.editText9);
    }
}