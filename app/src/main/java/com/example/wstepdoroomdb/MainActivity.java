package com.example.wstepdoroomdb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    SzkolaDatabase szkolaDatabase;
    EditText editText;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        szkolaDatabase = Room.databaseBuilder(
                getApplicationContext(), SzkolaDatabase.class, "szkola_db")
                .allowMainThreadQueries()
                .build();

//        szkolaDatabase.getNauczycielDao().wstawNauczycielaDoBazy(new Nauczyciel("Anna", "matematyka"));

        Button button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextText);
        spinner = findViewById(R.id.spinner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nauczyciel nauczyciel = new Nauczyciel(
                        editText.getText().toString(),
                        spinner.getSelectedItem().toString()
                );
                szkolaDatabase.getNauczycielDao().wstawNauczycielaDoBazy(nauczyciel);
            }
        });

    }
}