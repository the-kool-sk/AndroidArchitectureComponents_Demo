package com.example.demoapp.ui;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demoapp.DataRepository;
import com.example.demoapp.R;
import com.example.demoapp.room.AppDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        AppDatabase appDatabase= AppDatabase.getInstance(this);
        DataRepository dataRepository = DataRepository.getInstance(appDatabase);
        dataRepository.getUserDatafromWeb();

    }
}
