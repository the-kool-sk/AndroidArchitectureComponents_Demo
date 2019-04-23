package com.example.lifecycleawarecomponents;

import android.content.Context;
import android.location.LocationListener;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class BindingClass implements LifecycleObserver {

     BindingClass(LifecycleOwner lifecycleOwner) {

            lifecycleOwner.getLifecycle().addObserver(this);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        void oncreateIsCalled ()
        {

            Log.i("State", "OnCreatedState");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        void onStartIsCalled ()
        {
            Log.i("State", "OnStartedState");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        void onresumeIsCalled ()
        {
            Log.i("State", "OnResumedState");

        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        void onpauseIsCalled ()
        {
            Log.i("State", "OnPausedState");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        void onstopIsCalled ()
        {
            Log.i("State", "OnStoppedState");
        }
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        void ondestroyIsCalled ()
        {
            Log.i("State", "OnDestroyedState");
        }

    }
