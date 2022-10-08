package com.yifeng.pagingdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private TextView textView;

    private int count;

    private boolean isUpdateInfo;

    private static final int MSG_UPDATE_INFO = 0x10;

    private final HandlerThread handlerThread = new HandlerThread("check_message");

    private Handler handler;

    private final Handler uiHandler = new Handler();

    @Override
    protected void onPause() {
        super.onPause();
        isUpdateInfo = false;
        handler.removeMessages(MSG_UPDATE_INFO);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isUpdateInfo = true;
        handler.sendEmptyMessageDelayed(MSG_UPDATE_INFO, 1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);

        handlerThread.start();

        handler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what == MSG_UPDATE_INFO) {
                    updateMessage();
                    if (isUpdateInfo) {
                        handler.sendEmptyMessageDelayed(MSG_UPDATE_INFO, 3000);
                    }
                }
            }
        };

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            this.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                @Override
                public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                    Log.i("TAG", "onCreate");
                }

                @Override
                public void onActivityStarted(@NonNull Activity activity) {
                    Log.i("TAG", "onStart");
                }

                @Override
                public void onActivityResumed(@NonNull Activity activity) {
                    Log.i("TAG", "onResume");
                }

                @Override
                public void onActivityPaused(@NonNull Activity activity) {
                    Log.i("TAG", "onPause");
                }

                @Override
                public void onActivityStopped(@NonNull Activity activity) {
                    Log.i("TAG", "onStop");
                }

                @Override
                public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
                    Log.i("TAG", "onSaveInstance");
                }

                @Override
                public void onActivityDestroyed(@NonNull Activity activity) {
                    Log.i("TAG", "onDestroy");
                }
            });
        }
    }

    private void updateMessage() {
        uiHandler.post(() -> {
            count++;
            textView.setText(String.valueOf(count));
        });
    }

}