package com.example.colorseek;

import java.io.Serializable;

public class ColorInfo implements Serializable
{
    private int red;
    private int green;
    private int blue;
    private String hex;

    //GETTERS AND SETTERS===========================================================================
    public int getRed() {return red;}
    public void setRed(int red) {this.red = red;}
    public int getGreen() {return green;}
    public void setGreen(int green) {this.green = green;}
    public int getBlue() {return blue;}
    public void setBlue(int blue) {this.blue = blue;}
    public String getHex() {return hex;}
    public void setHex(String hex) {this.hex = hex;}
    //==============================================================================================
}


