package com.example.myapplication.location.work.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.myapplication.location.util.LogHelper;

public class PowerConnectionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_POWER_CONNECTED.equals(action)) {
            // 电源已连接
            LogHelper.log("PowerConnectionReceiver" + "Power connected.");
            // 执行电源连接时的操作
        } else if (Intent.ACTION_POWER_DISCONNECTED.equals(action)) {
            // 电源已断开
            LogHelper.log("PowerConnectionReceiver" + "Power disconnected.");
            // 执行电源断开时的操作
        }
    }
}
