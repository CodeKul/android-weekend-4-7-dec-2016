package com.melayer.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sLog.i("@codekul", "Long - "+prefs.getLong("typeLong", -9l ));
        Log.i("@codekul","Boolean - "+ prefs.getBoolean("typeBool", false));
        Log.i("@codekul","Integer - "+prefs.getInt("typeInt",-6));etContentView(R.layout.activity_main);

        prefs = getSharedPreferences("app_prefs", MODE_APPEND); // app level

        findViewById(R.id.btnWrite).setOnClickListener(this::write);
        findViewById(R.id.btnRead).setOnClickListener(this::read);
    }

    private void write(View view) {

        SharedPreferences.Editor edit = prefs.edit();
        edit.putLong("typeLong", 45l);
        edit.putBoolean("typeBool", true);
        edit.putInt("typeInt", 45);
        edit.putString("typeString", "codekul.com");
        edit.apply();
    }

    private void read(View view) {

        Log.i("@codekul", "Long - "+prefs.getLong("typeLong", -9l ));
        Log.i("@codekul","Boolean - "+ prefs.getBoolean("typeBool", false));
        Log.i("@codekul","Integer - "+prefs.getInt("typeInt",-6));
    }
}
