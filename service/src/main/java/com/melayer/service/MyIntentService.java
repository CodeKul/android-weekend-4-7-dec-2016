package com.melayer.service;

import android.app.IntentService;
import android.content.Intent;



public class MyIntentService extends IntentService {

    public MyIntentService(String name) {
        super(name);

        setIntentRedelivery(true);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // all in side thread
    }
}
