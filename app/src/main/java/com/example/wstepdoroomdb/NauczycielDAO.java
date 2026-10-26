package com.example.wstepdoroomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NauczycielDAO {
    @Insert
    void wstawNauczycielaDoBazy(Nauczyciel nauczyciel);
    @Insert
    void wstawListeNauczycieli(Nauczyciel...nauczyciele);
    @Delete
    void usunNauczycielaZBazy(Nauczyciel nauczyciel);
    @Update
    void zaktualizujDaneNauczyciela(Nauczyciel nauczyciel);
    @Query("SELECT * FROM nauczyciele")
    List<Nauczyciel> zwrocWszystkichNauczycieliZBazy();
    @Query("SELECT imie FROM nauczyciele WHERE przedmiot = :przedmiotArgument")
    List<String> zwrocImionaNauczycieliMatematyki(String przedmiotArgument);
}
