/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criapoligono.models;

import com.jogamp.opengl.GL2;

/**
 *
 * @author ximenes
 */
public class Color {
    private float red;
    private float blue;
    private float green;
    
    public Color(java.awt.Color color){
        this(
            color.getRed() / 255f,
            color.getGreen() / 255f,
            color.getBlue() / 255f
        );
    }
    
    @Override
    public String toString(){
        return "Color: R="+ this.red +" G="+ this.green +" B=" + this.blue;
    }

    public Color() {
        this(0f, 0f, 0f);
    }
    
    public Color(float red, float green, float blue) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }
    
    public void paint(GL2 gl){
        gl.glColor3f(red, green, blue);
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
