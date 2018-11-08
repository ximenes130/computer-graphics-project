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
        float minX = vertexes.firstElement().getX();
        float maxX = vertexes.firstElement().getX();
        float minY = vertexes.firstElement().getY();
        float maxY = vertexes.firstElement().getY();
        
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
    
    public void resize(float s){
        // Gerando matriz de transformação
        Float matrix[][] = {
            {s+1, 0f,  0f},
            {0f,  s+1, 0f},
            {0f,  0f,  1f}
        };
        
        // Multiplicando cada vertice do poligono
        for(Vertex v : vertexes){
            v.times(matrix);
        }
    }
    
    public void rotate(float x1, float y1, float x2, float y2){
        // Aplicando lei dos cossenos para descobrir o cosseno
        //   a² = b² + c² - 2 * b * c * cos A
        float a = (float) Math.sqrt(y1*y1 + Math.pow(x2-x1, 2));
        float b = (float) Math.sqrt(y1*y1 + Math.pow(x1-x2, 2));
        float c = x2;
        float cos = a*a - b*b + c*c / (2 * b * c);
        
        // Aplicando lei da relação fundamental para descobrir o seno
        //   sen²a + cos²a = 1
        float sin = (float) Math.sqrt(1 - cos*cos);
        System.out.println("Rotate: sin="+sin+" cos="+cos);
        
        // Gerando matriz de transformação
        Float matrix[][] = {
            {cos, -sin, 0f},
            {sin,  cos, 0f},
            {0f,   0f,  1f}
        };
        
        // Multiplicando cada vertice do poligono
        for(Vertex v : vertexes){
            v.times(matrix);
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
