package com.example.yultravel;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.yultravel.Plans.PlansActivity;

public class AlarmReceiver extends BroadcastReceiver {
    private NotificationManager mNotificationManager;
    private static final int NOTIFICATION_ID = 0;
    private static final String CHANNEL_ID = "channel";

    private Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        mNotificationManager = (NotificationManager)
                context.getSystemService(context.NOTIFICATION_SERVICE);
    }

    public void deliverNotification() {
        Intent contentIntent = new Intent(context, PlansActivity.class);

        // A pending intent is used for when multiple instances of the same intent are created
        // FLAG_UPDATE_CURRENT says to use the old intent, but replace the extras data
        PendingIntent contentPendingIntent = PendingIntent.getActivity(context,
                NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
