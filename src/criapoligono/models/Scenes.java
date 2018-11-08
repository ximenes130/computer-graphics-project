/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criapoligono.models;

import java.util.Vector;

/**
 *
 * @author ximenes
 */
public class Scenes extends Vector<Float[][]> {
    private int position;

    public Scenes() {
        super();
        this.position = 0;
    }
    
    @Override
    public synchronized boolean add(Float[][] e){
        for(int i = getPosition()+1 ; i < size() ; i++){
            this.remove(i);
        }
        
        if(super.add(e)){
            setPosition(size());
            return true;
        }
        return false;
    }
    
    @Override
    public synchronized Float[][] remove(int index){
        Float[][] e = super.remove(index);
        setPosition(size());
        return e;
    }
    
    public Float[][] getActual(){
        return get(position);
    }
    
    public Float[][] getPrevious(){
        setPosition(getPosition() - 1);
        return get(position);
    }
    
    public Float[][] getNext(){
        setPosition(getPosition() - 1);
        return get(position);
    }
    
    public boolean isFirst(){
        return position == 0;
    }
    
    public boolean isLast(){
        return position == size();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
