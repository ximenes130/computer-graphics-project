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
public class Vertex {
    private float x;
    private float y;

    public Vertex() {
        this(0f, 0f);
    }

    public Vertex(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public void draw(GL2 gl){
        System.out.println("X: " + x + "\tY: " + y);
        gl.glVertex2f(x,y);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
