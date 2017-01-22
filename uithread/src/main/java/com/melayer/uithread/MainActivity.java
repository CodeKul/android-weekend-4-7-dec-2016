package com.melayer.uithread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById(R.id.btnOkay).setOnClickListener(this::threadedCounter);
        //findViewById(R.id.btnOkay).setOnClickListener(v -> new MyTask().execute(1, 100, 500/*Params*/));
        //findViewById(R.id.btnOkay).setOnClickListener(v -> handlers());
        findViewById(R.id.btnOkay).setOnClickListener(v -> rxAndroid());
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

    int i = 0;
    private void handlers() {

        new Thread(() -> {
            for(i = 0; i < 100 ; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                new Handler(Looper.getMainLooper())
                        .post(() ->((TextView) findViewById(R.id.textCounter)).setText(String.valueOf(i)));
            }
        }).start();
    }

    private void threadedCounter(View view) {

        new Thread(
                () -> simpleCounter(view)
        ).start();
    }

    private class MyTask extends AsyncTask<Integer/*params*/, Integer/*progress*/, Boolean/*result*/> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // UI thread
        }

        @Override
        protected Boolean doInBackground(Integer... integers/*params*/) {

            for (int i = integers[0]; i < integers[1]; i++){
                try {
                    Thread.sleep(integers[2]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(i/*Progress*/);
            }
            // worker thread
            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            // UI thread
        }

        @Override
        protected void onProgressUpdate(Integer... values/*progress*/) {
            super.onProgressUpdate(values);

            ((TextView)findViewById(R.id.textCounter)).setText(String.valueOf(values[0]));
            // UI Thread
        }
    }

    private void rxAndroid() {

        // show dialog
        Observable.<Integer>create(vij ->{
            for (int i = 0; i < 100; i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                vij.onNext(i);
            }
            vij.onComplete();
        })      .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnNext( i -> ((TextView)findViewById(R.id.textCounter)).setText(String.valueOf(i)))
                .doOnComplete(() -> Log.i("@codekul", "On Completed ")  /*dismiss dialog*/)
                .subscribe();
    }
}
