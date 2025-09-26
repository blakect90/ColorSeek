package com.example.colorseek;

public class ColorInfo
{
    private int red;
    private int green;
    private int blue;
    private double luminance;
    private String hex;

    //default constructor
    public ColorInfo()
    {

    }

    //overloaded constructor
    public ColorInfo(int r, int g, int b, double l, String h)
    {
        red = r;
        green = g;
        blue = b;
        luminance = l;
        hex = h;
    }
}


