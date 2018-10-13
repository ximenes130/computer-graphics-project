/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criapoligono.controllers;

import criapoligono.models.Polygon;
import criapoligono.views.EditorView;
import java.util.Vector;

/**
 *
 * @author ximenes
 */
public class PoligonEditor {
    private EditorView editorView;
    private Vector<Polygon> polygons;
    //    private Scenes scenes; // TODO: Estudar melhor 
    public PoligonEditor() {
        this.editorView = new EditorView();
    }
    
}
