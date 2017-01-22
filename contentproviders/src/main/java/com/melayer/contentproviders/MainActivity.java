package com.melayer.contentproviders;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myProvider();
    }

    private void myProvider() {
        final List<String> data = new ArrayList<>();
        Uri uri = Uri.parse("content://com.codekul.provider.MY_TAB");
        String[] projection = null;
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        Cursor cursor = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);

        while(cursor.moveToNext()) {
            String num = cursor.getString(cursor.getColumnIndex("mob"));
            String name = cursor.getString(cursor.getColumnIndex("myName"));
            Log.i("@codekul", " Num - "+num +" Name - "+name);
            data.add(num + "\n"+name);
        }
        ((ListView)findViewById(R.id.listContacts)).setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data));
        cursor.close();
    }

    private void contactProvider() {
        final List<String> contacts = new ArrayList<>();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        Cursor contactCursor = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);

        while(contactCursor.moveToNext()) {
            String num = contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            String name = contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            contacts.add(num + "\n" +name);
        }
        ((ListView)findViewById(R.id.listContacts)).setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts));
        contactCursor.close();
    }
}
