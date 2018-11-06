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
public class BBox {
    private float minX;
    private float maxX;
    private float minY;
    private float maxY;

    public BBox() {
        this.minX = 0f;
        this.maxX = 0f;
        this.minY = 0f;
        this.maxY = 0f;
    }
    
    public void draw(GL2 gl){
        gl.glBegin(GL2.GL_LINE_LOOP);
        gl.glColor3f(0f, 0f, 0f);
        
        gl.glVertex2f(getMinX(),getMinY());
        gl.glVertex2f(getMinX(),getMaxY());
        gl.glVertex2f(getMaxX(),getMaxY());
        gl.glVertex2f(getMaxX(),getMinY());
        
        gl.glEnd();
    }
    
    public boolean isIn(Vertex point){
        if(point.getX() > getMaxX())
            return false;
        if(point.getY() > getMaxY())
            return false;
        if(point.getX() < getMinX())
            return false;
        if(point.getY() < getMinY())
            return false;
        return true;
    }

    public float getMinX() {
        return minX;
    }

    public void setMinX(float minX) {
        this.minX = minX;
    }

    public float getMaxX() {
        return maxX;
    }

    public void setMaxX(float maxX) {
        this.maxX = maxX;
    }

    public float getMinY() {
        return minY;
    }

    public void setMinY(float minY) {
        this.minY = minY;
    }

    public float getMaxY() {
        return maxY;
    }

    public void setMaxY(float maxY) {
        this.maxY = maxY;
    }
    
    
}
