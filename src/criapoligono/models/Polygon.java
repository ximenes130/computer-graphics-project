/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criapoligono.models;

import com.jogamp.opengl.GL2;
import java.util.Vector;

/**
 *
 * @author ximenes
 */
public class Polygon {
    private Vector<Vertex> vertexes;
    private Color color;

    public Polygon() {
        this.vertexes = new Vector<>();
        this.color = new Color();
    }
    
    public void draw(GL2 gl, boolean selected){
        System.out.println("# Desenhando poligono");
        // Iniciando desenho do poligono
        gl.glBegin(GL2.GL_POLYGON);
        
        // Definindo cor do desenho
        color.paint(gl);

        // Definindo vertices do poligono
        for(Vertex vertex : vertexes){
            vertex.draw(gl);
        }

        // Finalizando desenho
        gl.glEnd();
        
        // Desenhando borda
        if(selected){
            getBBox().draw(gl);
        }
    }
    
    public boolean isIn(Vertex point){
        return getBBox().isIn(point);
    }
    
    public BBox getBBox(){
        float minX = 0;
        float maxX = 0;
        float minY = 0;
        float maxY = 0;
        
        for(Vertex v : vertexes){
            if(v.getX() < minX)
                minX = v.getX();
            if(v.getX() > maxX)
                maxX = v.getX();
            if(v.getY() < minY)
                minY = v.getY();
            if(v.getY() > maxY)
                maxY = v.getY();
        }
        
        BBox resul = new BBox();
        resul.setMaxX(maxX);
        resul.setMinX(minX);
        resul.setMaxY(maxY);
        resul.setMinY(minY);
        
        return resul;
    }
    
    public void move(float x, float y){
        for(Vertex v : vertexes){
            v.setX(v.getX() + x);
            v.setY(v.getY() + y);
        }
    }
    
    public Vector<Vertex> addVertex(Vertex vertex){
        return addVertex(vertex, this.vertexes.size());
    }
    
    public Vector<Vertex> addVertex(Vertex vertex, int position){
        this.vertexes.add(position, vertex);
        return this.vertexes;
    }

    public Vector<Vertex> getVertexes() {
        return vertexes;
    }

    public void setVertexes(Vector<Vertex> vertexes) {
        this.vertexes = vertexes;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
