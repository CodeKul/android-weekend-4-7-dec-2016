package com.melayer.externalstorage;

import android.os.Environment;
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

        findViewById(R.id.btnSavePrivate).setOnClickListener(this::savePrivate);
        findViewById(R.id.btnRetrievePrivate).setOnClickListener(this::retrievePrivate);
        findViewById(R.id.btnSavePublic).setOnClickListener(this::writePublicData);
        findViewById(R.id.btnRetrievePublic).setOnClickListener(this::readPublicData);
    }

    private void retrievePrivate(View view) {

        try {
            if(isGood()) {
                File fileRoot = new File(getExternalFilesDir(""),"mt.txt");
                FileInputStream fis = new FileInputStream(fileRoot);
                StringBuilder builder = new StringBuilder();
                while(true){
                    int ch = fis.read();
                    if(ch == -1) break;
                    else builder.append((char)ch);
                }
                Log.i("@codekul","Retrieved Data is "+builder.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void savePrivate(View view) {
        // /storage/emulated/0/Android/data/com.melayer.externalstorage/files/mt.txt
        try {
            if(isGood()){
                File fileRoot = new File(getExternalFilesDir(""),"mt.txt");
                Log.i("@codekul", "getExternalFilesDir - "+fileRoot.getAbsolutePath());
                FileOutputStream fos = new FileOutputStream(fileRoot);
                fos.write("Again codekul.com".getBytes());
                fos.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean isGood() {
        return Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED);
    }

    public void writePublicData(View v){
        try {
            if(isGood()) {
                File fileRoot = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"my.txt");
                FileOutputStream fos = new FileOutputStream(fileRoot);
                fos.write("Yet again codekul.com".getBytes());
                fos.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void readPublicData(View v) {
        try {
            if(isGood()) {
                File fileRoot = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"my.txt");
                FileInputStream fis = new FileInputStream(fileRoot);
                StringBuilder builder = new StringBuilder();
                while(true){
                    int ch = fis.read();
                    if(ch == -1) break;
                    else builder.append((char)ch);
                }
                Log.i("@codekul","Retrieved Data is "+builder.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
