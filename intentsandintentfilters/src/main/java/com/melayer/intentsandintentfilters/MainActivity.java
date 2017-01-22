package com.melayer.intentsandintentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOkay).setOnClickListener(this::anyThing);
    }

    private void other(View view) {

        //Intent intent = new Intent(this, OtherActivity.class); explicit intent
        Intent intent = new Intent(); // implicit intent
        intent.setAction("com.codekul.action.OTHER");
        startActivity(intent);
    }

    private void anotherOne(View view) {
        Intent intent = new Intent(); // implicit intent
        intent.setAction("com.codekul.action.OTHER");
        intent.setData(Uri.parse("http://codekul.com"));
        startActivity(intent);
    }

    private void dialPad(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    private void call(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel://9762548833"));
        startActivity(intent);
    }

    private void anyThing(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("http://codekul.com"), "text/html");
        startActivity(intent);
    }
}
