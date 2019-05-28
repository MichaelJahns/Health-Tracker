package com.example.healthtracker;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class diaryActivity extends AppCompatActivity {
    EntryDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        db = Room.databaseBuilder(
                getApplicationContext(),
                EntryDatabase.class,
                "entry-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public void onExerciseRecord(View view) {
        EditText description = findViewById(R.id.diaryDescription);
        EditText length = findViewById(R.id.diaryLength);
        RadioGroup radioMood = findViewById(R.id.diaryMood);
        RadioButton active = findViewById(radioMood.getCheckedRadioButtonId());

        Entry entry = new Entry();
        entry.setDescription(String.valueOf(description.getText()));
        entry.setLength(String.valueOf(length.getText()));
        entry.setMood(Integer.parseInt(String.valueOf(active.getText())));

        db.entryDAO().add(entry);
    }
}
