package com.example.healthtracker;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.healthtracker.backend.Entry;
import com.example.healthtracker.backend.EntryDAO;

@Database(entities = {Entry.class}, version = 1)
public abstract class EntryDatabase extends RoomDatabase {
    public abstract EntryDAO entryDAO();
}
