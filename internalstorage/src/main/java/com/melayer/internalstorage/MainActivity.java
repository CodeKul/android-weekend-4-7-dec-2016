package com.melayer.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSave).setOnClickListener(this::save);
        findViewById(R.id.btnRetrieve).setOnClickListener(this::retrieve);
        findViewById(R.id.btnImp).setOnClickListener(this::impMethods);
    }

    private void impMethods(View view) {

        String []files = fileList();
        for (String file : files) {
         Log.i("@codekul","File List - "+file);
        }

        File internalStorageRoot = getFilesDir();
        Log.i("@codekul","Internal Storage Root is "+internalStorageRoot);

        // ---> /data/user/0/com.melayer.internalstorage/files
        // ---> /data/user/0/com.melayer.internalstorage/shared_prefs
        // ---> /data/user/0/com.melayer.internalstorage/database


        File newDir = new File(internalStorageRoot, String.valueOf(System.currentTimeMillis()));
        if(!newDir.exists())
            newDir.mkdir();

    }

    private void retrieve(View view) {

        try {
            FileInputStream fis = openFileInput("my.txt");
            StringBuilder builder = new StringBuilder();
            while(true){
                int ch = fis.read();
                if(ch == -1) break;
                else builder.append((char)ch);
            }
            Log.i("@codekul",builder.toString());
            fis.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void save(View view) {

        try{
            FileOutputStream fos = openFileOutput("my.txt",MODE_PRIVATE);
            fos.write("This is codekul.com".getBytes());
            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
