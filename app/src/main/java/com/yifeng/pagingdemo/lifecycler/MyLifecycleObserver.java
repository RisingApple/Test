package com.yifeng.pagingdemo.lifecycler;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLifecycleObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onStart() {
        Log.i("START", "activity onStart");
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
        Log.i("STOP", "activity onStop");
    }

}
