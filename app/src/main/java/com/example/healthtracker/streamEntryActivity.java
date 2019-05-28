package com.example.healthtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class streamEntryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    EntryLayoutAdapter adapter;
    EntryDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_entry);

        database = Room.databaseBuilder(
                getApplicationContext(),
                EntryDatabase.class,
                "entry-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        List<Entry> entries = database.entryDAO().getAll();

        entries.add(new Entry("Farted while runnin", "5:5", 3));
        entries.add(new Entry("Ran really far", "23:12", 4));
        entries.add(new Entry("Ow", "5:5", 1));

        recyclerView = findViewById(R.id.recycler_stream);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new EntryLayoutAdapter(entries);
        recyclerView.setAdapter(adapter);
    }
}
