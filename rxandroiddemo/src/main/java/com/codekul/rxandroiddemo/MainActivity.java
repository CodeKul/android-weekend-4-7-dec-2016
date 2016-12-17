package com.codekul.rxandroiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.observables.AsyncOnSubscribe;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       readDb().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(s -> ((TextView)findViewById(R.id.textView)).setText(s))
                .doOnError(throwable -> Log.i("@melayer","Error - "+throwable.toString()))
                .doOnCompleted(() -> Log.i("@melayer","completed"))
                .subscribe();
    }

    private Observable<String> readDb(){

        return Observable.create(subscriber -> {
            for(int i = 0 ; i < 1000 ; i++) {
                subscriber.onNext(""+i);
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            subscriber.onCompleted();
        });
    }

    Observable<String> my = Observable.create(new AsyncOnSubscribe<String, String>() {
        @Override
        protected String generateState() {
            return null;
        }

        @Override
        protected String next(String state, long requested, Observer<Observable<? extends String>> observer) {
            return null;
        }
    });
}
