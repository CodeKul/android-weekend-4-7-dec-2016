package com.codekul.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<String> dataSet;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customAdapter();

    }

    private void customAdapter() {
        ArrayList<MyItem> dataSet = new ArrayList<>();

        MyItem itemBus = new MyItem(1l, R.drawable.ic_buses ,"Bus" );
        dataSet.add(itemBus);

        MyItem itemChopper = new MyItem(2l, R.drawable.ic_chopper ,"Chopper" );
        dataSet.add(itemChopper);

        MyItem itemCycle = new MyItem(3l, R.drawable.ic_cycle ,"Cycle" );
        dataSet.add(itemCycle);

        MyItem itemTruck = new MyItem(4l, R.drawable.ic_deliverytruck ,"Truck" );
        dataSet.add(itemTruck);

        MyItem itemScooter = new MyItem(4l, R.drawable.ic_motorbiking ,"Scooter" );
        dataSet.add(itemScooter);

        MyAdapter adapter = new MyAdapter(this, dataSet);

        ListView listOs = (ListView) findViewById(R.id.listOs);
        listOs.setOnItemClickListener(this::listItemClick);
        listOs.setAdapter(adapter);
    }

    private void arrayAdapter() {

        dataSet = new ArrayList<>();
        dataSet.add("Android");
        dataSet.add("iOS");
        dataSet.add("Rim");
        dataSet.add("Symbian");
        dataSet.add("Windows");
        dataSet.add("ubuntu");
        dataSet.add("Fedora");

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dataSet );

        ListView listOs = (ListView) findViewById(R.id.listOs);
        listOs.setOnItemClickListener(this::listItemClick);
        listOs.setAdapter(adapter);

        findViewById(R.id.btnAdd).setOnClickListener(this::click);
    }

    private void click(View view) {
        String typedOs = ((EditText) findViewById(R.id.edtOs)).getText().toString();

        if(typedOs.length() > 0)
            dataSet.add(typedOs);
        adapter.notifyDataSetChanged();
    }

    private void listItemClick(AdapterView<?> adapterView, View view, int i, long l) {

       /* TextView text = (TextView) view;
        EditText edtOs = (EditText) findViewById(R.id.edtOs);
        edtOs.setText(text.getText().toString());*/

       /* ((EditText) findViewById(R.id.edtOs))
                .setText(((TextView) view).getText().toString());*/

        TextView text = (TextView) view.findViewById(R.id.textItem);
        ((EditText) findViewById(R.id.edtOs))
                .setText(text.getText().toString());

    }
}
