package com.example.yultravel;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import static androidx.core.content.ContextCompat.getSystemService;

public class YULNotification {
    private Context ctx;
    private String title;
    private String description;

    private static final String CHANNEL_ID = "channel";
    private static final int NOTIFICATION_ID = 0;
    private NotificationManager mNotifyManager; // Delivers notifications to user

    public YULNotification(Context ctx, NotificationManager n, String title, String description) {
        this.ctx = ctx;
        this.title = title;
        this.description = description;
        mNotifyManager = n;

        createNotificationChannel();
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
