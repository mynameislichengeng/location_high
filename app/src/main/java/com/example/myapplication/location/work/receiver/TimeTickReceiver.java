package com.example.myapplication.location.work.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.myapplication.location.util.LogHelper;

public class TimeTickReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_TIME_TICK.equals(action)) {
            // 每分钟的时间滴答广播
            LogHelper.log("TimeTickReceiver" + "Time tick received at " + System.currentTimeMillis());
            // 执行每分钟的操作
        }
    }
}
