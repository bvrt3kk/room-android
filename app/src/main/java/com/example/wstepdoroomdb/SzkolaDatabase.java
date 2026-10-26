package com.example.wstepdoroomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Nauczyciel.class}, version = 1)
public abstract class SzkolaDatabase extends RoomDatabase {
    public abstract NauczycielDAO getNauczycielDao();
}
