package com.melayer.deepstreamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.Objects;

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
                ds = new DeepstreamClient( "192.168.2.5:6020" );
                ds.login();
                ds.setRuntimeErrorHandler((topic, event, s) -> {
                    Log.i("@melayer", "Topic - "+topic +" Event - "+ event +" String - "+s);
                });
                ds.addConnectionChangeListener(connectionState -> {
                    Log.i("@melayer", "Connection state - "+connectionState);
                });
                ds.event.subscribe("fromWeb", this::inComingEvent);
                ds.event.subscribe("otherMobile", this::inComingEvent);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }).start();

        findViewById(R.id.btnOkay).setOnClickListener(this::okay);
        findViewById(R.id.btnOther).setOnClickListener(this::otherClick);
    }

    private void otherClick(View view) {
        ds.event.emit("otherMobile",new Object[]{new Date().toString()});
    }

    private void inComingEvent(String s, Object... objects) {
        Log.i("@melayer","InComing Event from server");
        //((TextView)findViewById(R.id.textInComing)).setText(s);
    }

    private void okay(View view){
        Log.i("@melayer","okay clicked");
        ds.event.emit("fromMobile",new Object[]{new Date().toString()});
    }
}
