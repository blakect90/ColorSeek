package com.example.colorseek;

import java.util.ArrayList;

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
    //GETTERS AND SETTERS==============================================================================
    public int getRed() {return red;}
    public void setRed(int red) {this.red = red;}
    public int getGreen() {return green;}
    public void setGreen(int green) {this.green = green;}
    public int getBlue() {return blue;}
    public void setBlue(int blue) {this.blue = blue;}
    public double getLuminance() {return luminance;}
    public void setLuminance(double luminance) {this.luminance = luminance;}
    public String getHex() {return hex;}
    public void setHex(String hex) {this.hex = hex;}
    //==============================================================================================

//    static class savedColor
//    {
//        static ArrayList<String> savedColor = new ArrayList<>();
//        public static String savedColorAt(int i) {return savedColor.get(i);}
//        public static void addSavedColor
//    }
}


