package com.example.zaccianflone.pantrypro.database;

import android.text.style.TtsSpan;

import com.example.zaccianflone.pantrypro.Constants;
import com.firebase.client.Firebase;

import java.util.HashMap;

/**
 * Created by Ben on 7/11/2016.
 */
public class Create extends DatabaseUpdate{
    //private Firebase firebase;

    public void child(String type) {

    }

    public void execute(HashMap<String, Object> values, String type) {
        Firebase firebase = new Firebase(Constants.FIREBASE_SAVE);

        firebase.child(type).updateChildren(values);

//        HashMap<String, Object> grandChild = new HashMap<>();
//        grandChild.put("Quantity", "2");
//        grandChild.put("Color", "Green");
//        grandChild.put("Store", "Sams");
////
//        HashMap<String, Object> children = new HashMap<>();
//        children.put("Recipe", grandChild);
//        firebase.updateChildren(children);
    }

    public void finish() {

    }
}
