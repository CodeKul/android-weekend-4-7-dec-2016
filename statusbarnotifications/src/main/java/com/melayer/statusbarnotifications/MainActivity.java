package com.melayer.statusbarnotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int ID_SIMPLE = 1245;
    private static final int REQ_SIMPLE = 8965;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnNotify).setOnClickListener(this::notify);
    }

    private void notify(View view) {


        Intent intent = new Intent(this,NotificationActivity.class);

        PendingIntent contentIntent = PendingIntent.getActivity(this, REQ_SIMPLE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(getResources().getString(R.string.notificationTitle))
                .setContentText(getResources().getString(R.string.notificationText))
                .setContentInfo(getResources().getString(R.string.notificationInfo))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(contentIntent)
                .setDefaults(Notification.DEFAULT_ALL);

        Notification notification = builder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(ID_SIMPLE, notification);
    }
}
