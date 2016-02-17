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
    public static final int boxSize = 10;
    private int n;
    private int i;
    public int x2=0,y2=0;
    private Boolean topOf=false,rightOf=false,sideOf=false,leftOf=false;
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
    atTheTopOf AtTheTopOf= new atTheTopOf();
    atTheRightOf AtTheRightOf= new atTheRightOf();
    atTheLeftOf AtTheLeftOf= new atTheLeftOf();
    insideOf insideOf= new insideOf();

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
        if(topOf==true){
           for (ObjectDrawing obj : objects) {
                   if (obj.getObjectName().equals(objName)) {
                       obj.setPoint(x2, y2);
                   }
           }
        }else if(rightOf==true){
            for (ObjectDrawing obj : objects) {
                   if (obj.getObjectName().equals(objName)) {
                       obj.setPoint(x2, y2);
                   }
           }
        }else if(leftOf==true){
           for (ObjectDrawing obj : objects) {
                   if (obj.getObjectName().equals(objName)) {
                       obj.setPoint(x2, y2);
                   }
           }
        }else if(sideOf==true){
           for (ObjectDrawing obj : objects) {
                   if (obj.getObjectName().equals(objName)) {
                       obj.setPoint(x2, y2);
                   }
           }
        }else{
            for (ObjectDrawing obj : objects) {
                   if (obj.getObjectName().equals(objName)) {
                       obj.setPoint(x, y);
                   }
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
    public void atTheTopOf(String objL, String objN) {
         int max= objects.size();
         int l;
         for(n=0; n<max-1;){
            if(objects.get(n).getObjectName().equals(objL)){
                break;
            }else{
                 n++;
            }
         }
         for(l=0; l<max-1;){
            if(objects.get(l).getObjectName().equals(objN)){
                break;
            }else{
                 l++;
            }
         }
        if (objects.get(n).getObjectName().equals(objL)) {
            if(objects.get(l).getObjectName().equals(objN)){
                  AtTheTopOf.AtTheTopOf(objects.get(n), objects.get(l));
                  x2= AtTheTopOf.x3;
                  y2=AtTheTopOf.y3;
                 topOf=true;
                 //draw(objN,x2,y2);
                /*objects.add(new ObjectDrawing(objL));
                 objects.get(l).setOriginX(x2);
                 objects.get(l).setOriginY(y2);*/
            }
        }
    }
      public void atTheRightOf(String objL, String objN) {
         int max= objects.size();
         int l;
         for(n=0; n<max-1;){
            if(objects.get(n).getObjectName().equals(objL)){
                break;
            }else{
                 n++;
            }
         }
         for(l=0; l<max-1;){
            if(objects.get(l).getObjectName().equals(objN)){
                break;
            }else{
                 l++;
            }
         }
        if (objects.get(n).getObjectName().equals(objL)) {
            if(objects.get(l).getObjectName().equals(objN)){
                 AtTheRightOf.AtTheRightOf(objects.get(n), objects.get(l));
                  x2= AtTheRightOf.x3;
                  y2=AtTheRightOf.y3;
                  rightOf=true;
                 /*objects.add(new ObjectDrawing(objL));
                 objects.get(l).setOriginX(x2);
                 objects.get(l).setOriginY(y2);*/
            }
        }
    }
     public void atTheLeftOf(String objL, String objN) {
         int max= objects.size();
         int l;
         for(n=0; n<max-1;){
            if(objects.get(n).getObjectName().equals(objL)){
                break;
            }else{
                 n++;
            }
         }
         for(l=0; l<max-1;){
            if(objects.get(l).getObjectName().equals(objN)){
                break;
            }else{
                 l++;
            }
         }
        if (objects.get(n).getObjectName().equals(objL)) {
            if(objects.get(l).getObjectName().equals(objN)){
                 AtTheLeftOf.AtTheLeftOf(objects.get(n), objects.get(l));
                  x2= AtTheLeftOf.x3;
                  y2=AtTheLeftOf.y3;
                  leftOf=true;
                 /*objects.add(new ObjectDrawing(objL));
                 objects.get(l).setOriginX(x2);
                 objects.get(l).setOriginY(y2);*/
            }
        }
    }
      public void insideOf(String objL, String objN) {
         int max= objects.size();
         int l;
         for(n=0; n<max-1;){
            if(objects.get(n).getObjectName().equals(objL)){
                break;
            }else{
                 n++;
            }
         }
         for(l=0; l<max-1;){
            if(objects.get(l).getObjectName().equals(objN)){
                break;
            }else{
                 l++;
            }
         }
        System.out.println("diri ha ok! first " +objects.get(n).getObjectName());
        System.out.println("diri ha ok! sec " +objects.get(l).getObjectName());
        if (objects.get(n).getObjectName().equals(objL)) {
            if(objects.get(l).getObjectName().equals(objN)){
                 insideOf.InsideOf(objects.get(n), objects.get(l));
                  x2= insideOf.x3;
                  y2=insideOf.y3;
                  sideOf=true;
                 System.out.println("x2: "+x2);
                 System.out.println("y2: "+y2);
                 /*objects.add(new ObjectDrawing(objL));
                 objects.get(l).setOriginX(x2);
                 objects.get(l).setOriginY(y2);*/
            }
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
        for (i = 1; i <= 69; i++) {
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
