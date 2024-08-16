package com.example.myapplication.location.work.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

import com.example.myapplication.location.util.LogHelper;

public class BatteryStatusReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        LogHelper.log("接受到电量变化");
        if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                    status == BatteryManager.BATTERY_STATUS_FULL;

            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            float batteryPct = level / (float) scale;

            // 根据电池状态执行操作
            if (isCharging) {
                LogHelper.log("BatteryStatusReceiver" + "Battery is charging, level: " + batteryPct * 100 + "%");
            } else {
                LogHelper.log("BatteryStatusReceiver" + "Battery is not charging, level: " + batteryPct * 100 + "%");
            }
        }
    }
}
