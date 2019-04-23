package com.example.lifecycleawarecomponents;

import android.content.Context;
import android.location.LocationListener;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class BindingClass implements LifecycleObserver {

    Context mContext;

    public BindingClass(LifecycleOwner lifecycleOwner, Context context) {
        this.mContext = context;
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void oncreateIsCalled()
    {
        Log.i("Event","OnCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStartIsCalled()
    {
        Log.i("Event","OnStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onresumeIsCalled()
    {
        Log.i("Event","OnResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onpauseIsCalled()
    {
        Log.i("Event","OnPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onstopIsCalled()
    {
        Log.i("Event","OnStop");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void ondestroyIsCalled()
    {
        Log.i("Event","OnDestroy");
    }

}
