package com.example.lifecycleawarecomponents;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class BindingClass implements LifecycleObserver {

    LifecycleOwner lifecycleOwner;
     BindingClass(LifecycleOwner lifecycleOwner) {

            this.lifecycleOwner=lifecycleOwner;
            lifecycleOwner.getLifecycle().addObserver(this);
            Log.i("ActivityLifeCycleStatus", lifecycleOwner.getLifecycle().getCurrentState().toString()+" State");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        void oncreateIsCalled ()
        {
            Log.i("ActivityLifeCycleStatus", "OnCreated-ObserverEvent");
            Log.i("ActivityLifeCycleStatus", lifecycleOwner.getLifecycle().getCurrentState().toString()+" State");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        void onStartIsCalled ()
        {
            Log.i("ActivityLifeCycleStatus", "OnStarted-ObserverEvent");
            Log.i("ActivityLifeCycleStatus", lifecycleOwner.getLifecycle().getCurrentState().toString()+" State");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        void onresumeIsCalled ()
        {
            Log.i("ActivityLifeCycleStatus", "OnResumed-ObserverEvent");
            Log.i("ActivityLifeCycleStatus", lifecycleOwner.getLifecycle().getCurrentState().toString()+" State");

        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        void onpauseIsCalled ()
        {
            Log.i("ActivityLifeCycleStatus", "OnPaused-ObserverEvent");
            Log.i("ActivityLifeCycleStatus", lifecycleOwner.getLifecycle().getCurrentState().toString()+" State");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        void onstopIsCalled ()
        {
            Log.i("ActivityLifeCycleStatus", "OnStopped-ObserverEvent");
            Log.i("ActivityLifeCycleStatus", lifecycleOwner.getLifecycle().getCurrentState().toString()+" State");
        }
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        void ondestroyIsCalled ()
        {
            Log.i("ActivityLifeCycleStatus", "OnDestroyed-ObserverEvent");
            Log.i("ActivityLifeCycleStatus", lifecycleOwner.getLifecycle().getCurrentState().toString()+" State");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void anEvent(){

         Log.i("ActivityLifeCycleStatus", "Any-ObserverEvent");
         Log.i("ActivityLifeCycleStatus", lifecycleOwner.getLifecycle().getCurrentState().toString()+" State");
     }

        @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void anyEvent(){

         Log.i("ActivityLifeCycleStatus", "Any-ObserverEvent");
         Log.i("ActivityLifeCycleStatus", lifecycleOwner.getLifecycle().getCurrentState().toString()+" State");
     }

    }
