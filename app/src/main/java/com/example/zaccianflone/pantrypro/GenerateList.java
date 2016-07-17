package com.example.zaccianflone.pantrypro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.zaccianflone.pantrypro.model.Recipe;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class GenerateList extends AppCompatActivity {

    /**
     * When the user clicks back go to Main Activity
     * @param view
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, ViewPantry.class);
        startActivity(intent);
    }
}
