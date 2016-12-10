package com.codekul.weekendapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout.LayoutParams paramsRoot
                = new LinearLayout.LayoutParams(300,300);
        LinearLayout layoutRoot = new LinearLayout(this);
        layoutRoot.setLayoutParams(paramsRoot);
        layoutRoot.setOrientation(LinearLayout.VERTICAL);
        setContentView(layoutRoot);

        LinearLayout.LayoutParams paramsBtn
                = new LinearLayout.LayoutParams(300,150);
        Button btnOkay = new Button(this);
        btnOkay.setText("Okay");
        layoutRoot.addView(btnOkay);
    }
}
