package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class NextActivity extends AppCompatActivity {

    public static final String KEY_SELECTED_IMG = "selectedImage";
    private int selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        ((Button)findViewById(R.id.btnBack)).setText(getMyStr());
        findViewById(R.id.btnBack).setOnClickListener(this::click);
        findViewById(R.id.imageBt).setOnClickListener(this::click);
        findViewById(R.id.imageCam).setOnClickListener(this::click);
        findViewById(R.id.imageTone).setOnClickListener(this::click);
        findViewById(R.id.imageUp).setOnClickListener(this::click);
    }

    private void click(View view) {

        if(view.getId() == R.id.btnBack) {
            Intent data = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_SELECTED_IMG, selectedImage);
            data.putExtras(bundle);
            setResult(RESULT_OK,data);
            finish();
        }
        if(view.getId() == R.id.imageBt) {
            selectedImage = R.drawable.ic_bluetooth_black_24dp;
            ((ImageView)findViewById(R.id.imageBt)).setColorFilter(Color.parseColor("#e8e8e8"));
            ((ImageView)findViewById(R.id.imageUp)).setColorFilter(Color.parseColor("#000000"));
            ((ImageView)findViewById(R.id.imageCam)).setColorFilter(Color.parseColor("#000000"));
            ((ImageView)findViewById(R.id.imageTone)).setColorFilter(Color.parseColor("#000000"));
        }
        if(view.getId() == R.id.imageCam) {
            selectedImage = R.drawable.ic_camera_alt_black_24dp;

            ((ImageView)findViewById(R.id.imageBt)).setColorFilter(Color.parseColor("#000000"));
            ((ImageView)findViewById(R.id.imageUp)).setColorFilter(Color.parseColor("#000000"));
            ((ImageView)findViewById(R.id.imageCam)).setColorFilter(Color.parseColor("#e8e8e8"));
            ((ImageView)findViewById(R.id.imageTone)).setColorFilter(Color.parseColor("#000000"));
        }
        if(view.getId() == R.id.imageTone) {
            selectedImage = R.drawable.ic_audiotrack_black_24dp;

            ((ImageView)findViewById(R.id.imageBt)).setColorFilter(Color.parseColor("#000000"));
            ((ImageView)findViewById(R.id.imageUp)).setColorFilter(Color.parseColor("#000000"));
            ((ImageView)findViewById(R.id.imageCam)).setColorFilter(Color.parseColor("#000000"));
            ((ImageView)findViewById(R.id.imageTone)).setColorFilter(Color.parseColor("#e8e8e8"));
        }
        if(view.getId() == R.id.imageUp) {
            selectedImage = R.drawable.ic_backup_black_24dp;

            ((ImageView)findViewById(R.id.imageBt)).setColorFilter(Color.parseColor("#000000"));
            ((ImageView)findViewById(R.id.imageUp)).setColorFilter(Color.parseColor("#e8e8e8"));
            ((ImageView)findViewById(R.id.imageCam)).setColorFilter(Color.parseColor("#000000"));
            ((ImageView)findViewById(R.id.imageTone)).setColorFilter(Color.parseColor("#000000"));
        }
    }

    private String getMyStr(){
        Intent parentIntent = getIntent();
        String myStr = "";
        if(parentIntent != null){
            Bundle bundle = parentIntent.getExtras();
            myStr = bundle.getString(MainActivity.KEY_MY_STR);
        }
        return myStr;
    }
}
