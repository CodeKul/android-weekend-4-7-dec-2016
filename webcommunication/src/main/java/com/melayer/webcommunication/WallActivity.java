package com.melayer.webcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class WallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall);

        findViewById(R.id.btnRegister).setOnClickListener(this::register);
    }

    private void register(View view) {
        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        findViewById(R.id.btnRegister).setEnabled(false);
        JSONObject obj = new JSONObject();
        try {
            obj.put("userName", getUserName());
            obj.put("password", getPassword());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Q.q(this).add(new JsonObjectRequest("https://digital-shelter-153912.firebaseio.com/me.json", obj, this::success, this::error));
    }

    private void error(VolleyError volleyError) {
        findViewById(R.id.progressBar).setVisibility(View.GONE);
        findViewById(R.id.btnRegister).setEnabled(true);
    }

    private void success(JSONObject jsonObject) {
        findViewById(R.id.progressBar).setVisibility(View.GONE);
        findViewById(R.id.btnRegister).setEnabled(true);
    }

    private String getUserName() {
        return ((EditText)findViewById(R.id.edtUserName)).getText().toString();
    }

    private String getPassword() {
        return ((EditText)findViewById(R.id.edtPassword)).getText().toString();
    }
}
