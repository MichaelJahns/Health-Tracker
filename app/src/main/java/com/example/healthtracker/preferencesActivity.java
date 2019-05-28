package com.example.healthtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.healthtracker.MainActivity;
import com.example.healthtracker.R;
import com.example.healthtracker.preferences.PreferencesHelper;

public class preferencesActivity extends AppCompatActivity {

    TextView greetName;
    EditText editName;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        greetName = findViewById(R.id.greeting);
        editName = findViewById(R.id.editName);
        SharedPreferences preferences = PreferencesHelper.getPreferences(this);

        name = preferences.getString(MainActivity.NAME_KEY, "New User!");

        greetName.setText("Welcome back, " + name +"!");
        editName.setText(name);
    }

    public void onNameEdit(View view){
        this.name = editName.getText().toString();
        greetName.setText(this.name);
    }
}
