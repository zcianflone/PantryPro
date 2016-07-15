package com.example.zaccianflone.pantrypro;

import android.widget.EditText;

/**
 * Created by zaccianflone on 6/18/16.
 */
public final class Constants {

    /**
     * Constants for Firebase URL
     */

    public static final String FIREBASE_URL = "https://fiery-inferno-4832.firebaseio.com/";

    public static final String FIREBASE_SAVE = "https://fiery-inferno-4832.firebaseio.com/android/saving-data/Pantry";

    public static final String KEY_LIST_ID = "LIST_ID";

    public static final String FIREBASE_BEN = "https://pantrytro-firebase.firebaseio.com/android/saving-data/Pantry";

    public static final Boolean checkFields(EditText text) {
        String sText = text.getText().toString();
        if (sText.matches("")) {
            return false;
        }
        else {
            return true;
        }

    }
}
