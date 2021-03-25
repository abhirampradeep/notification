package com.abhirampradeep.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class remainder  extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent repeating = new Intent(context,repeating_activity.class);
        repeating.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"notify")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_baseline_access_alarm_24)
                .setContentTitle("count details")
                .setContentText("please enter the count")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);



        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);

        notificationManager.notify(200,builder.build());
    }
}
