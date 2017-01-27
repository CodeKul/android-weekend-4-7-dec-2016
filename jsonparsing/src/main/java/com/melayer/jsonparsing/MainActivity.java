package com.melayer.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parseJson(readFile());

        parseUsingGson(readFile());
    }

    private String readFile(){
        final StringBuilder builder = new StringBuilder();
        try {
            InputStream is = getAssets().open("my.json");
            while (true){
                int ch = is.read();
                if(ch == -1) break;
                else builder.append((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private void parseJson(String json) {

        try {
            JSONObject  rootObj = new JSONObject(json);

            String color = rootObj.getString("color");
            Log.i("@codekul", "Color - "+color);

            int price = rootObj.getInt("price");
            Log.i("@codekul", "Price - "+price);

            JSONArray types = rootObj.getJSONArray("types");
            for (int i = 0; i < types.length() ; i++){
                Log.i("@codekul", " "+types.get(i));
            }

            JSONObject innerObj = rootObj.getJSONObject("global");
            Boolean isBitter = innerObj.getBoolean("bitter");
            Log.i("@codekul", "Is it bitter "+isBitter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseUsingGson(String json){

        Gson gson = new Gson();
        Fruit fruit = gson.fromJson(json, Fruit.class);
        Log.i("@codekul", "Fruit is - "+fruit.toString());
    }
}
