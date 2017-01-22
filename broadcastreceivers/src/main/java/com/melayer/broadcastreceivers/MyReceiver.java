package com.melayer.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("@codekul","I received AIRPLANE MODE "+intent.getAction());
        Toast.makeText(context,"I received AIRPLANE MODE "+intent.getAction(), Toast.LENGTH_SHORT).show();
    }
}
