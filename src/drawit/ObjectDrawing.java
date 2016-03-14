/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawit;

import static drawit.DrawIt.boxSize;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Class for the object variable to be drawn i.e house, window,door
 *
 * @author Red Viper
 */
public class ObjectDrawing {
    
    private int i;
    
    private String objectName;

    /*
    ** array of x indexes of the object drawn specified by the move function
     */
    private ArrayList<Integer> x;
    /*
    ** array of y indexes of the object drawn specified by the move function
     */
    private ArrayList<Integer> y;
    /*
    ** color of the object specified by the fill function
     */
    private Color color;

    public ObjectDrawing(String name) {
        initialize();
        this.objectName = name;
        
    }

    public void initialize() {
        x = new ArrayList<Integer>();
        y = new ArrayList<Integer>();
    }

    public void fill(Color color) {

    }

    /*
    ** returns the size of the list
     */
    public int getSize() {
        return x.size();
    }

    public int getSizeY() {
        return y.size();
    }

    /**
     * @return the x
     */
    public ArrayList<Integer> getListX() {
        return x;
    }

    /**
     * Returns the x at the specified position in this list.
     */
    public int getX(int index) {
        return x.get(index);
    }

    /**
     * @param num adds num to the x list
     */
    public void addX(int num) {
        x.add(num);
    }

    /**
     * @return the y
     */
    public ArrayList<Integer> getListY() {
        return y;
    }

    /**
     * Returns the y at the specified position in this list.
     */
    public int getY(int index) {
        return y.get(index);
    }

    /**
     * @param num adds num to the y list
     */
    public void addY(int num) {
        y.add(num);
    }
    
    public void draw(Graphics g){
      
        for (i = 0; i < getSize(); i++) {
              g.setColor(color);
            g.fillRect(getX(i) * boxSize - boxSize, 700 - (getY(i) * boxSize), boxSize, boxSize);
        }
    }

    /**
     * @return the objectName
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * @param objectName the objectName to set
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
    
    /*
    ** sets the starting point for drawing in the frame 
    ** Frame is like a cartersian plane
    ** where (1,1) is the first box at bottom left
     */
    public void setPoint( int x, int y, Color color) {
        addX(x);
        addY(y);
        DrawIt.x = x;
        DrawIt.y = y;
        this.color = color;
    }
    
}
