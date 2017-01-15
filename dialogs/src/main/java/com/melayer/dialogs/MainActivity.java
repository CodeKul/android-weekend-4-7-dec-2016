package com.melayer.dialogs;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAlert).setOnClickListener(v -> showDialog(MyDialog.TAG_ALERT));
        findViewById(R.id.btnDatePicker).setOnClickListener(v -> showDialog(MyDialog.TAG_DATE_PICKER));
        findViewById(R.id.btnTimePicker).setOnClickListener(v -> showDialog(MyDialog.TAG_TIME_PICKER));
        findViewById(R.id.btnProgress).setOnClickListener(v -> showDialog(MyDialog.TAG_PROGRESS));
        findViewById(R.id.btnCustom).setOnClickListener(v -> showDialog(MyDialog.TAG_CUSTOM));
    }

    private void alertDialog(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("Yes",(di, which) ->{})
                .setNegativeButton("No", (di, which) ->{});
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showDialog(String tag){
        MyDialog dialog = new MyDialog();
        dialog.show(getSupportFragmentManager(), tag);
    }
}
