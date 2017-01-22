package com.melayer.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

public class MyService extends Service {

    private MediaPlayer player; // i am just giving example,  media player directly comes with builtin service
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(() -> {
            player = MediaPlayer.create(this, R.raw.my);
            player.start();
        }).start();

        //return super.onStartCommand(intent, flags, startId);
        //return START_NOT_STICKY
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
        super.onDestroy();
    }
}
