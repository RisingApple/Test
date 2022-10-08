package com.yifeng.pagingdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBrocastReceiver extends BroadcastReceiver {

    private static final String ACTION_TEST1 = "ACTION_TEST1";
    private static final String ACTION_TEST2 = "ACTION_TEST2";
    private static final String ACTION_TEST3 = "ACTION_TEST3";

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case ACTION_TEST1:
                break;
            case ACTION_TEST2:
                break;
            case ACTION_TEST3:
                break;
            default:
                break;
        }
    }
}
