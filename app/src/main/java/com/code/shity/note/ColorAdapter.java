package com.code.shity.note;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorAdapter  extends BaseAdapter {
    private int [] mColors;

    private LayoutInflater mLayoutInflater;

    public ColorAdapter(Context context, int [] colors) {
        mColors = colors;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return mColors.length;
    }

    @Override
    public Object getItem(int position) {
        return mColors[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public int getColor(int position) {
        return (int)getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mLayoutInflater.inflate(R.layout.color_item, parent, false);
        convertView.findViewById(R.id.ColorItemView).setBackgroundColor(getColor(position));

        return convertView;
    }
}
