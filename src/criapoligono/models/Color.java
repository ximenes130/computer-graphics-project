/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criapoligono.models;

/**
 *
 * @author ximenes
 */
public class Color {
    private float red;
    private float blue;
    private float green;

    public Color() {
    }
    
    public Color(float red, float blue, float green) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }
    
    public void setAll(float red, float blue, float green) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public float getRed() {
        return red;
    }

    public void setRed(float red) {
        this.red = red;
    }

    public float getBlue() {
        return blue;
    }

    public void setBlue(float blue) {
        this.blue = blue;
    }

    public float getGreen() {
        return green;
    }

    public void setGreen(float green) {
        this.green = green;
    }
}
