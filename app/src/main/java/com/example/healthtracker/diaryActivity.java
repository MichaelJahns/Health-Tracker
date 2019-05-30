package com.example.healthtracker;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.healthtracker.backend.APIUtilities;
import com.example.healthtracker.backend.Entry;
import com.example.healthtracker.backend.EntryService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class diaryActivity extends AppCompatActivity {
    EntryDatabase db;
    private EntryService mEntryService;

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

        Button onlineSubmit = findViewById(R.id.diarySpringSubmit);
        final EditText describeBox = findViewById(R.id.diaryDescription);
        final EditText lengthBox = findViewById(R.id.diaryLength);
        final RadioGroup radioMood = findViewById(R.id.diaryMood);

        mEntryService = APIUtilities.getEntryService();

        onlineSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RadioButton active = findViewById(radioMood.getCheckedRadioButtonId());

                String description = describeBox.getText().toString().trim();
                String length = lengthBox.getText().toString().trim();
                int mood = Integer.parseInt(active.getText().toString());

                if(!TextUtils.isEmpty(description) && !TextUtils.isEmpty(length) && 0 < mood && mood < 6){
                    sendPost(description, length, mood);
                }
            }
        });
    }

    public void sendPost(String description, String length, int mood) {
        mEntryService.createEntry(description, length, mood).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.e("RETROFIT", "POST sent to SERVER:  " + response.code());


            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("RETROFIT", "Unable to submit post to API.", t);

            }
        });
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
