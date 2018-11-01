package com.example.sparks.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Base_Adapter extends BaseAdapter {
    Context context;
    List<Model>list;
    LayoutInflater inflater;

    public Base_Adapter(Context context, List<Model> list) {
        this.context=context;
        this.list=list;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.dataitem,null);
        TextView name1=(TextView)convertView.findViewById(R.id.txt);

        Model model=list.get(position);


        name1.setText(model.getName());
        name1.setBackgroundColor(Color.parseColor(model.getColor()));

        return convertView;
    }
}
