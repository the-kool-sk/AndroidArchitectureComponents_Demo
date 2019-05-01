package com.example.lifecycleawarecomponents;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new BindingClass(this);
        Log.i("ActivityLifeCycleStatus", "OnCreated-Activity");
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
