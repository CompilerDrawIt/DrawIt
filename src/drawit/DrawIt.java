/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Red Viper
 */
public class DrawIt extends JFrame {
    private Image dbImage;
    private Graphics dbg;
    public static final int boxSize = 3;
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
    /**
     * List of objects for var from the syntax Draw var
     */
    private ArrayList<ObjectDrawing> objects;

    Move move = new Move();

    public DrawIt() {
          objects = new ArrayList<ObjectDrawing>();
    }

    public void initialize() {
        setTitle("Draw It");
        setSize(700, 700);
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        

        //example call for draw when draw is inputted
        //draw("house", 20, 20);
        //example call for move
        //move(Constants.direction.LEFT, "house");
    }

    public void draw(String objName, int x, int y) {
        System.out.println("name:"+objName);
        objects.add(new ObjectDrawing(objName));
        //setPoint
        

        //move(Constants.direction.UPWARDRIGHT, objName);
    }
    
    public void setPoint(String objName, int x, int y){
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
     *
     * @param objectname the object to be copied
     */
    public void copy(String objectname) {

    }

    /**
     * method to call for move
     */
    public void move(Constants.direction direction, String objectName) {
        n = 0;
        System.out.println("hi"+objectName);
        while (objects.size()-1 > n && objects.get(n).getObjectName() != (objectName)) {
            n++;
        }

        if (objects.get(n).getObjectName().equals(objectName)) {
            move.move(direction, objects.get(n), x, y);
        }
    }

    public void paint(Graphics g){
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        draw(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        /*
        **   69x70 boxes  at 10x10 pixels each
         */
        for (i = 1; i <= 232; i++) {
            g.drawLine(0, i * boxSize, 700, i * boxSize);
            g.drawLine(i * boxSize, 0, i * boxSize, 700);
        }
        for (ObjectDrawing obj : objects) {
            obj.draw(g);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        JFrame Editor= new JFrame("Draw it");
        Editor.setBounds(50, 100, 800, 500);
        Editor.getContentPane().add(new Compiler());
        Editor.setVisible(true);
        Editor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
