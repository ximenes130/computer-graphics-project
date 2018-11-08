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
            setPosition(size() - 1);
            System.out.println("----- +1 Scene: position="+getPosition());
            return true;
        }
        return false;
    }
    
    @Override
    public synchronized Float[][] remove(int index){
        Float[][] e = super.remove(index);
        setPosition(size() - 1);
        return e;
    }
    
    public Float[][] getActual(){
        return get(position);
    }
    
    public Float[][] getPrevious(){
        if((getPosition()-1) < 0)
            return null;
        setPosition(getPosition() - 1);
        System.out.println("----- Prev Scene: position="+getPosition());
        return get(position);
    }
    
    public Float[][] getNext(){
        if(getPosition() >= size())
            return null;
        setPosition(getPosition() + 1);
        System.out.println("----- Next Scene: position="+getPosition());
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
