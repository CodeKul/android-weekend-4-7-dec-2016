package com.melayer.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private DbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DbHelper(this,Db.DB_NAME,null,1);

        findViewById(R.id.btnInsert).setOnClickListener(this::rawInsert);
        findViewById(R.id.btnUpdate).setOnClickListener(this::update);
        findViewById(R.id.btnDelete).setOnClickListener(this::delete);
        findViewById(R.id.btnQuery).setOnClickListener(this::query);
    }

    private void query(View view) {
        SQLiteDatabase sqDb = helper.getReadableDatabase();
        String table = Db.TAB_NAME;
        //String[] columns = {Db.COL_MOB};
        String[] columns = null;
        //String selection = Db.COL_MY_NAME + " = ?";
        String selection = null;
//        String[] selectionArgs = {getName()};
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        final Cursor cursor = sqDb.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
        while(cursor.moveToNext()){
            String mob = cursor.getString(cursor.getColumnIndex(Db.COL_MOB));
            String name = cursor.getString(cursor.getColumnIndex(Db.COL_MY_NAME));
            Log.i("@codekul", "Mobile - "+mob + " Name - "+name);
            //Log.i("@codekul", "Mobile - "+mob);
        }

        sqDb.close();
    }

    private void delete(View view) {

        SQLiteDatabase sqDb = helper.getWritableDatabase();
        String table = Db.TAB_NAME;
        String where = Db.COL_MY_NAME +" = ?";
        String []whereArgs = {getName()};

        sqDb.delete(table, where, whereArgs);

        sqDb.close();
    }

    private void update(View view) {

        SQLiteDatabase sqDb = helper.getWritableDatabase();

        String table = Db.TAB_NAME;
        ContentValues values = new ContentValues();
        values.put(Db.COL_MY_NAME, getName());
        String where = Db.COL_MOB +" = ?";
        String []whereArgs ={getMobile()};
        sqDb.update(table, values, where, whereArgs);

        sqDb.close();
    }

    private void insert(View view) {
        SQLiteDatabase sqDb = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Db.COL_MOB, getMobile());
        values.put(Db.COL_MY_NAME, getName());
        sqDb.insert(Db.TAB_NAME, null, values );
        sqDb.close();
    }

    private void rawInsert(View view) {
        SQLiteDatabase sqDb = helper.getWritableDatabase();
        sqDb.execSQL("insert into myTab values('986521345','Mouse')");
        sqDb.close();
    }

    private String getMobile() {
        return ((EditText)findViewById(R.id.edtMobile)).getText().toString();
    }

    private String getName() {
        return ((EditText)findViewById(R.id.edtName)).getText().toString();
    }
}
