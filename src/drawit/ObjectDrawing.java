/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawit;

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

    private ArrayList<Points> points;
    
    /*
    ** color of the object specified by the fill function
     */

    private Color color;

    public ObjectDrawing(String name) {
        initialize();
        this.objectName = name;
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
        points.add(new Points(x,y,color));
        DrawIt.x = x;
        DrawIt.y = y;
    }
    

    public void initialize() {
        points = new ArrayList<Points>();
    }

    
    public void draw(Graphics g){
          for (Points p : points) {
           p.draw(g);
        }  
    }
}
