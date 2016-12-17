package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_MY_INT = "myInt";
    public static final String KEY_MY_STR = "myStr";
    private static final int REQ_NEXT_ACT = 135;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnNext).setOnClickListener(this::click);
    }

    private void click(View view) {
        Intent intent = new Intent(this, NextActivity.class);

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_MY_INT, 1234);
        bundle.putString(KEY_MY_STR,"Hello");
        intent.putExtras(bundle);

        //startActivity(intent);
        startActivityForResult(intent,REQ_NEXT_ACT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_NEXT_ACT) {
            if(resultCode == RESULT_OK) {
                if(data != null){
                    int selectedImage = data.getIntExtra(NextActivity.KEY_SELECTED_IMG,-4);
                    ((ImageView)(findViewById(R.id.imageCartoon))).setImageResource(selectedImage);
                }
            }
        }
    }
}
