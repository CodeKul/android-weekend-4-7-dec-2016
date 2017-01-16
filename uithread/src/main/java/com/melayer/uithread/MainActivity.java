package com.melayer.uithread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOkay).setOnClickListener(this::threadedCounter);
    }

    private void simpleCounter(View view) {

        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((TextView) findViewById(R.id.textCounter)).setText(String.valueOf(i));
        }
    }

    private void threadedCounter(View view) {

        new Thread(
                () -> simpleCounter(view)
        ).start();
    }

    private class MyTask extends AsyncTask<Integer/*params*/, Integer/*progress*/, Boolean/*result*/> {

        @Override
        protected Boolean doInBackground(Integer... integers) {
            return null;
        }
    }
}
