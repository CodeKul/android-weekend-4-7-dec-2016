package com.codekul.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by aniruddha on 31/12/16.
 */

public class CodeKulView extends EditText{

    private float px, py;

    private Paint paint;
    public CodeKulView(Context context) {
        super(context);

        // when u r creating view from code

        paint = new Paint();
        paint.setColor(Color.BLUE);

        startProducingSpots();
    }

    public CodeKulView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // when u r creating view from xml

        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(14);

        startProducingSpots();
    }

    private void startProducingSpots() {

        Flowable.interval(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnNext(tick -> {
                    px = (float) (Math.random() *  getWidth());
                    py = (float) (Math.random() * getHeight());

                    Log.i("@codekul","Px - "+px +" Py - "+py);
                    invalidate();
                })
                .subscribe();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       // canvas.drawCircle(10,10,20,paint);
        //canvas.drawText("CodeKul",50,10,paint);
        canvas.drawCircle(px,py,10,paint);
    }


}
