package com.example.healthtracker;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EntryDAO {

    @Query("SELECT * FROM Entry")
    List<Entry> getAll();

    @Insert
    void add(Entry entry);

    @Update
    void update(Entry entry);

    @Delete
    void delete(Entry entry);
}
