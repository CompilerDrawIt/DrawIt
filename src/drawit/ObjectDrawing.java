/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawit;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;

/**
 * Class for the object variable to be drawn i.e house, window,door
 *
 * @author Red Viper
 */
public class ObjectDrawing {

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
    private int color;

    public ObjectDrawing(int x, int y) {
        initialize();
        addX(x);
        addY(y);
        
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

}
