package com.melayer.deepstreamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URISyntaxException;

import io.deepstream.DeepstreamClient;
import io.deepstream.EventListener;

public class MainActivity extends AppCompatActivity {

    private DeepstreamClient ds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(()->{
            try {
                ds = new DeepstreamClient( "192.168.2.4:6020" );
                ds.login();

                ds.event.subscribe("fromWeb", this::inComingEvent);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }).start();


        findViewById(R.id.btnOkay).setOnClickListener(this::okay);
    }

    private void inComingEvent(String s, Object... objects) {
        ((TextView)findViewById(R.id.textInComing)).setText(s);
    }

    private void okay(View view){
        Log.i("@melayer","okay clicked");
        new Thread(() ->{
            ds.event.emit("fromMobile","Hello");
        }).start();
    }
}
