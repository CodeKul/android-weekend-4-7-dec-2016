package com.codekul.configurationchangesown;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mt("onCreate");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.ic_chopper);
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.ic_cycle);
        }
        else {
            ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.ic_suv);
        }
    }

    @Override
    protected void onDestroy() {
        mt("onDestroy");
        super.onDestroy();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mt("onRestart");
    }

    private void mt(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
