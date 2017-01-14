package com.melayer.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnToast).setOnClickListener(this::customToast);
    }

    private void showToast(View view) {
        Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show();
    }

    private void customToast(View view) {
        Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
         Button btn = new Button(this);
        btn.setText("Okay");
        toast.setView(btn);
        toast.show();
    }
}
