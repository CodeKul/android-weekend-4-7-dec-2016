package com.melayer.prasadmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnFirst).setOnClickListener(this::firstClicked);
        findViewById(R.id.btnSecond).setOnClickListener(this::secondClicked);
        findViewById(R.id.btnThird).setOnClickListener(this::thirdClicked);
        findViewById(R.id.btnFourth).setOnClickListener(this::fourthClicked);
        findViewById(R.id.btnFifth).setOnClickListener(this::fifthCilcked);
        findViewById(R.id.btnSixth).setOnClickListener(this::sixthClicked);
    }

    private void sixthClicked(View view) {

        Intent intent = new Intent(this, SixthActivity.class);
        startActivity(intent);
    }

    private void fifthCilcked(View view) {

        Intent intent = new Intent(this, FifthActivity.class);
        startActivity(intent);
    }

    private void fourthClicked(View view) {

        Intent intent = new Intent(this, FourthActivity.class);
        startActivity(intent);
    }

    private void thirdClicked(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    private void secondClicked(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private void firstClicked(View view) {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }
}
