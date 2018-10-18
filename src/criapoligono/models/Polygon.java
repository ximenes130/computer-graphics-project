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
    
    public void draw(GL2 gl){
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
