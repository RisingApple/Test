package com.yifeng.pagingdemo.lifecycler;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public class MyLifecycleObserver2 implements LifecycleEventObserver {

    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
        switch (event) {

            case ON_START:
                Log.i("START", "onStart");
                break;

            case ON_STOP:
                Log.i("STOP", "onStop");
                break;

            default:
                break;
        }
    }
}
