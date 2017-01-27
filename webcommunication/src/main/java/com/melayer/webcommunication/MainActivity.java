package com.melayer.webcommunication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gson = new Gson();
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnLogin).setOnClickListener(this::login);
    }

    private void login(View view) {
        Q.q(this).add(new StringRequest("https://digital-shelter-153912.firebaseio.com/me.json",this::onSuccess, this::onError));
    }

    private void onError(VolleyError volleyError) {
        VolleyLog.wtf("Error is %s", volleyError.getMessage());
    }

    private void onSuccess(String s) {
        Log.i("@codekul","Incoming "+s);

        User user = gson.fromJson(s, User.class);
        if(user.getUserName().equals(getUserName()) && user.getPassword().equals(getPassword())) {
            startActivity(new Intent(this, WallActivity.class));
        }
    }

    private String getUserName() {
        return ((EditText)findViewById(R.id.edtUserName)).getText().toString();
    }
    private String getPassword() {
        return ((EditText)findViewById(R.id.edtPassword)).getText().toString();
    }
}
