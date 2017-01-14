package com.codekul.simplevalueresources;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float headerHeight = getResources().getDimension(R.dimen.companyHeaderHeight);

        String companyName = getResources().getString(R.string.companyName);
        int color = getResources().getColor(R.color.companyHeaderColor);
        color = ContextCompat.getColor(this,R.color.companyHeaderColor);
    }
}
