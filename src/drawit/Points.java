/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawit;

import static drawit.DrawIt.boxSize;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Red Viper
 */

public class Points {
       /*
    ** array of x indexes of the object drawn specified by the move function
     */
    private int x;
    /*
    ** array of y indexes of the object drawn specified by the move function
     */
    private  int y;
    private Color color;
    public Points(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x* boxSize - boxSize, 700 - (y * boxSize), boxSize, boxSize);
    }
}


