package com.example.yultravel;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;

import androidx.core.app.NotificationCompat;

import com.example.yultravel.Plans.PlansActivity;

import static androidx.core.content.ContextCompat.getSystemService;

public class YULNotification {
    private Context ctx;
    private String title;
    private String description;

    private static final String CHANNEL_ID = "channel";
    private static final int NOTIFICATION_ID = 0;
    private NotificationManager mNotifyManager; // Delivers notifications to user

    public YULNotification(Context ctx, String title, String description) {
        this.ctx = ctx;
        this.title = title;
        this.description = description;
        mNotifyManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);

        createNotificationChannel();

        Intent notifyIntent = new Intent(ctx, AlarmReceiver.class);
        PendingIntent notifyPendingIntent = PendingIntent.getBroadcast(ctx, NOTIFICATION_ID,
                notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) ctx.getSystemService(Context.ALARM_SERVICE);
        long repeatInterval = 1000;
        long triggerTime = repeatInterval;
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime,
                repeatInterval, notifyPendingIntent);
    }

    /**
     * Creates a notification channel
     */
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notifChannel = new NotificationChannel(CHANNEL_ID, "Mascot",
                    NotificationManager.IMPORTANCE_HIGH);
            notifChannel.enableLights(true);
            notifChannel.setLightColor(Color.RED);
            notifChannel.enableVibration(true);
            notifChannel.setDescription("This is a notification");
            mNotifyManager.createNotificationChannel(notifChannel);
        }
    }

    /**
     * Constructs the actual notification
     * @return
     */
    private NotificationCompat.Builder getNotificationBuilder() {
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(ctx,
                CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(description)
                .setSmallIcon(R.drawable.plans_flat_icon);
        return notifyBuilder;
    }

    public void showNotification() {
        NotificationCompat.Builder n = getNotificationBuilder();
        mNotifyManager.notify(NOTIFICATION_ID, n.build());
    }
}
