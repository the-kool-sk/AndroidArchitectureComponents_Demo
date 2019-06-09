package com.example.lifecycleawarecomponents;
import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new BindingClass(this);
        Log.i("ActivityLifeCycleStatus", "OnCreated-Activity");

        for(int a=0;a<10;a++)
        {
            list.add("Suraj"+a);
        }
        SearchView searchView = findViewById(R.id.mySV);
        final RecyclerView recyclerView=findViewById(R.id.myRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final MyAdapter adapter = new MyAdapter(list,this);
        recyclerView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                    adapter.myfilter(newText);
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityLifeCycleStatus", "OnStart-Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityLifeCycleStatus", "OnResumed-Activity");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ActivityLifeCycleStatus", "OnPaused-Activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ActivityLifeCycleStatus", "OnStopped-Activity");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ActivityLifeCycleStatus", "OnRestarted-Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ActivityLifeCycleStatus", "OnDestroyed-Activity");
    }
}
