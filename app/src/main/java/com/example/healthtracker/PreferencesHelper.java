package com.example.healthtracker;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.healthtracker.R;

public class PreferencesHelper {
    public static SharedPreferences getPreferences(Activity activity){
        String filename = activity.getString(R.string.preferences_file);
        SharedPreferences preferences = activity.getSharedPreferences(filename, Context.MODE_PRIVATE);
        return preferences;
    }
}
