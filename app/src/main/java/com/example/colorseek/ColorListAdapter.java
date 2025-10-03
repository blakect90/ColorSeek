package com.example.colorseek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
    public View getView(int position, View view, ViewGroup parent)
    {
        if (view == null)
        {
            LayoutInflater mmInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mmInflater.inflate(R.layout.color_list_cell, null);
        }
        TextView tv_j_Red = view.findViewById(R.id.tv_v_cell_Red);
        TextView tv_j_Green = view.findViewById(R.id.tv_v_cell_Green);
        TextView tv_j_Blue = view.findViewById(R.id.tv_v_cell_Blue);
        TextView tv_j_Hex = view.findViewById(R.id.tv_v_cell_Hex);

        ColorInfo colorInfo = colorList.get(position);

        tv_j_Red.setText(String.valueOf(colorInfo.getRed()));
        tv_j_Green.setText(String.valueOf(colorInfo.getGreen()));
        tv_j_Blue.setText(String.valueOf(colorInfo.getBlue()));
        tv_j_Hex.setText(colorInfo.getHex());

        return view;
    }
}
