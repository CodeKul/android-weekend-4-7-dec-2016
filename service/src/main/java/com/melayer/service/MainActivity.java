package com.melayer.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, MyService.class);

        findViewById(R.id.btnStart).setOnClickListener(this::startMusic);
        findViewById(R.id.btnStop).setOnClickListener(this::stopMusic);
    }

    private void stopMusic(View view) {
        stopService(intent);
    }

    private void startMusic(View view) {
        startService(intent);
    }
}
