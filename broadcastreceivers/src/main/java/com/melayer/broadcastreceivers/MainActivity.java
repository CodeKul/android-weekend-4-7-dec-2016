package com.melayer.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Toast.makeText(context, "Changed", Toast.LENGTH_SHORT).show();
            if(intent.getBooleanExtra("state",false)) {
                findViewById(R.id.imageView).setVisibility(View.VISIBLE);
            }
            else {
                findViewById(R.id.imageView)
                        .startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.disappear));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction("com.codekul.custom.ACTION_BROADCAST");
        registerReceiver(receiver, filter);

        findViewById(R.id.btnBroadcast).setOnClickListener(this::broadcast);
    }

    private void broadcast(View view) {

        Intent intent = new Intent("com.codekul.custom.ACTION_BROADCAST");
        sendBroadcast(intent);
    }
}
