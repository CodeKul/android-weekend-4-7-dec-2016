package com.codekul.uixml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Click cl = new Click();
        final Button btnOkay = (Button) findViewById(R.id.btnOkay);
        //btnOkay.setOnClickListener(cl);
        //findViewById(R.id.btnReset).setOnClickListener(cl);

        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView textCodeKul = (TextView) findViewById(R.id.textCodeKul);
                textCodeKul.setText("{code}kul;");
            }
        });

        findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textCodeKul = (TextView) findViewById(R.id.textCodeKul);
                textCodeKul.setText("codekul");
            }
        });

        findViewById(R.id.btnUpperCase).setOnClickListener( v -> ((TextView) findViewById(R.id.textCodeKul)).setText("codekul".toUpperCase()) );

        findViewById(R.id.btnLowerCase).setOnClickListener(this::loweCase);
    }

    private void loweCase(View view) {
        if(view.getId() == R.id.btnLowerCase){
            ((TextView) findViewById(R.id.textCodeKul)).setText("codekul");
        }
    }

    private class Click implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btnOkay){

            }
            else {

            }
        }
    }
}
