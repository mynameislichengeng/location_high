package com.example.myapplication.location.work.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.myapplication.location.util.LogHelper;

public class ScreenStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_SCREEN_ON.equals(action)) {
            // 屏幕亮起
            LogHelper.log("ScreenStateReceiver" + "Screen ON.");
            // 执行屏幕亮起时的操作
        } else if (Intent.ACTION_SCREEN_OFF.equals(action)) {
            // 屏幕熄灭
            LogHelper.log("ScreenStateReceiver" + "Screen OFF.");
            // 执行屏幕熄灭时的操作
        }
    }
}
