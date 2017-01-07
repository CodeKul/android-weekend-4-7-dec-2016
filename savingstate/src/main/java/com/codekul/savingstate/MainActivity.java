package com.codekul.savingstate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_TEXT_INFO = "textInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*if(savedInstanceState != null){
            String textInfo = savedInstanceState.getString(KEY_TEXT_INFO);
            ((TextView)findViewById(R.id.textInfo)).setText(textInfo);
        }*/

        findViewById(R.id.btnOkay).setOnClickListener(this::clicked);

        mt("onCreate");
    }

    @Override
    protected void onDestroy() {
        mt("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        mt("onSavedInstanceState");
        outState.putString(KEY_TEXT_INFO, ((TextView)findViewById(R.id.textInfo)).getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null){
            String textInfo = savedInstanceState.getString(KEY_TEXT_INFO);
            ((TextView)findViewById(R.id.textInfo)).setText(textInfo);
        }
    }

    private void clicked(View view) {
        ((TextView)findViewById(R.id.textInfo))
                .setText(String.valueOf(System.currentTimeMillis()));
    }
    
    private void mt(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
