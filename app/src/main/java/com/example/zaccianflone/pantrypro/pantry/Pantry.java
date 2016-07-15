package com.example.zaccianflone.pantrypro.pantry;

import com.example.zaccianflone.pantrypro.Constants;
import com.example.zaccianflone.pantrypro.database.Create;
import com.example.zaccianflone.pantrypro.database.Remove;
import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ben on 7/12/2016.
 */
public interface Pantry {
    Firebase firebase = new Firebase(Constants.FIREBASE_SAVE);
    //List<String> values = null;


    void addOrEdit(List<String> items);
    void remove(List<String> items);

}
