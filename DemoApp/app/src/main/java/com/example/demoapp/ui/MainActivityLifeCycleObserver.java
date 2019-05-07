package com.example.demoapp.ui;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.demoapp.DataRepository;
import com.example.demoapp.room.AppDatabase;

public class MainActivityLifeCycleObserver implements LifecycleObserver {
    LifecycleOwner lifecycleOwner;
    Context context;

    public MainActivityLifeCycleObserver(LifecycleOwner lifecycleOwner, Context context) {
        this.lifecycleOwner = lifecycleOwner;
        this.context=context;
        this.lifecycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void webServiceCall()
    {
        AppDatabase appDatabase= AppDatabase.getInstance(context);
        DataRepository dataRepository = DataRepository.getInstance(appDatabase);
        dataRepository.getUserDatafromWeb();
    }
}
