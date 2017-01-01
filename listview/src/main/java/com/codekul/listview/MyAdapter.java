package com.codekul.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aniruddha on 1/1/17.
 */

public final class MyAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<MyItem> dataSet;
    private LayoutInflater inflater;

    public MyAdapter(Context context, ArrayList<MyItem> dataSet) {
        this.context = context;
        this.dataSet = dataSet;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dataSet.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if(convertView == null) view = inflater.inflate(R.layout.list_item,parent,false);
        else view = convertView;

        ((ImageView)view.findViewById(R.id.imageItem)).setImageResource(dataSet.get(position).getImage());
        ((TextView)view.findViewById(R.id.textItem)).setText(dataSet.get(position).getText());

        return view;
    }
}
