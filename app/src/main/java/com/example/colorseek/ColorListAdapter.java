package com.example.colorseek;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> colorList;
    public ColorListAdapter(Context c, ArrayList<ColorInfo> cl)
    {
        context = c;
        colorList = cl;
    }
    @Override
    public int getCount()
    {
        return colorList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return colorList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return null;
    }
}
