package com.codekul.compoundviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.compound_view, (LinearLayout) findViewById(R.id.layoutRoot), false);*/


        findViewById(R.id.btnAdd).setOnClickListener(this::click);
    }

    private void click(View view) {
        LinearLayout layoutRoot = (LinearLayout) findViewById(R.id.layoutRoot);
        layoutRoot.addView(makeCompoundView());
    }

    private View makeCompoundView(){
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View inflatedView = inflater.inflate(R.layout.compound_view, null, false);

        EditText edtUserName = (EditText) inflatedView.findViewById(R.id.edtUserName);
        edtUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((TextView)findViewById(R.id.textInfo)).setText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return inflatedView;
    }
}
