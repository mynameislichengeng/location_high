package com.example.myapplication.location.work;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.myapplication.location.MainActivity;
import com.example.myapplication.location.R;
import com.example.myapplication.location.util.LogHelper;

public class ForegroundService extends Service {
    private static final int NOTIFICATION_ID = 1;
    private NotificationManager notificationManager;
    private NotificationCompat.Builder notificationBuilder;
    private Notification notification;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // 返回 null，因为我们不使用绑定服务
        return null;
    }

    @SuppressLint("ForegroundServiceType")
    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
        startForeground(NOTIFICATION_ID, createNotification());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 这里执行您的后台任务
        doBackgroundTask();

        // 返回 START_STICKY 以确保服务被杀死后会自动重启
        return START_STICKY;
    }

    private void doBackgroundTask() {
        // 执行您的后台任务，例如网络请求、文件处理等
        // 示例：打印一条消息
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    LogHelper.log("Running background task...");
                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {


                    }
                }
            }
        }).start();



    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("foreground_service_channel",
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private Notification createNotification() {
        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_IMMUTABLE);

        notificationBuilder = new NotificationCompat.Builder(this, "foreground_service_channel")
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("Foreground Service")
                .setContentText("Service is running in the foreground.")
                .setContentIntent(resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        return notificationBuilder.build();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        stopForeground(true);
    }
}
