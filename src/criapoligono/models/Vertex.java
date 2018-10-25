/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criapoligono.models;

import com.jogamp.opengl.GL2;
import criapoligono.helpers.Matrix;

/**
 *
 * @author ximenes
 */
public class Vertex {
    private Float x;
    private Float y;

    public Vertex() {
        this(0f, 0f);
    }

    public Vertex(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public void times(Float matrix[][]){
       Float result[][] = Matrix.multiply(this.toMatrix(), matrix);
       setAll(result);
    }
    
    public Float[] toArray(){
        Float a[] = {getX(), getY()};
        return a;
    }
    
    public Float[][] toMatrix(){
        Float a[][] = {toArray()};
        return a;
    }
    
    public void draw(GL2 gl){
        System.out.println("X: " + x + "\tY: " + y);
        gl.glVertex2f(x,y);
    }
    
    public void setAll(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public void setAll(Float[][] matrix){
        setAll(matrix[0][0], matrix[0][1]);
    }

    public Float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
