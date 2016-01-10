/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawit;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Red Viper
 */
public class DrawIt extends JFrame {
    private int n;
    private int i;
    /*
    ** current point x of drawing
     */
    public static int x;
    /*
    ** current point y of drawing
     */
    public static int y;
    /*
    ** List of objects from the syntax Draw var
     */
    private ArrayList<ObjectDrawing> objects;

    Move move = new Move();

    public DrawIt() {
        initialize();
    }

    public void initialize() {
        setTitle("Draw It");
        setSize(700, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        objects = new ArrayList<ObjectDrawing>();

        //example call for draw when draw is inputted
        draw("house", 20, 20);
        //example call for move
        move(Constants.direction.LEFT,"house");
    }
    
    
    public void draw(String objName, int x, int y) {
        objects.add(new ObjectDrawing(objName));
        //setPoint
        for (ObjectDrawing obj : objects) {
            if (obj.getObjectName().equals(objName)) {
                obj.setPoint(x, y);
            }
        }
    }

    /**
     * 
     * @param n number of loop
     */
    public void times(int n) {

    }

    /**
     * method to call for copy
     * @param objectname the object to be copied
     */
    public void copy(String objectname) {
        
    }

    /*
    ** method to call for move
     */
    public void move(Constants.direction direction, String objectName) {
        n = 0;
        while(objects.size() > n && objects.get(n).getObjectName() != (objectName)){
            n++;        
        }
        if(objects.get(n).getObjectName().equals(objectName)){
            move.move(direction, objects.get(n), x, y);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        /*
        **   28x27 boxes  at 25x25 pixels each
         */
        for (i = 1; i <= 27; i++) {
            g.drawLine(0, i * 25, 700, i * 25);
            g.drawLine(i * 25, 0, i * 25, 700);
        }
        for (ObjectDrawing obj : objects) {
            obj.draw(g);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        DrawIt d = new DrawIt();
    }

}
