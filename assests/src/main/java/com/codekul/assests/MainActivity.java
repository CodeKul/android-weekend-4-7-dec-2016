package com.codekul.assests;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Typeface typeface = Typeface.createFromAsset(getAssets(),"cur.ttf");
        ((TextView)findViewById(R.id.textInfo)).setTypeface(typeface);

    }

    private InputStream readFontData() {

        InputStream fontStream = null;;
        try {
            fontStream = getAssets().open("cur.ttf");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fontStream;
    }
}
