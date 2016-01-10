/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawit;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Red Viper
 */
public class DrawIt extends JFrame {

    private int i;
    /*
    ** current point x of drawing
     */
    public static int x;
    /*
    ** current point y of drawing
     */
    public static int y;

    ObjectDrawing obj;

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
        setPoint(obj, 5, 5);
        obj = new ObjectDrawing(x, y);
        move(Constants.direction.UPWARDRIGHT);
        move(Constants.direction.UP);


    }

    public void move(Constants.direction direction) {
        move.move(direction, obj, x, y);
    }

    /*
    ** sets the starting point for drawing in the frame 
    ** Frame is like a cartersian plane
    ** where (1,1) is the first box at bottom left
     */
    public void setPoint(ObjectDrawing obj, int x, int y) {
        this.x = x;
        this.y = y;
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
        g.setColor(Color.black);
        for (i = 0; i < obj.getSize(); i++) {
            g.fillRect(obj.getX(i) * 25 - 25, 700 - (obj.getY(i) * 25), 25, 25);
//            System.out.println("x[" + i + "]: " + obj.getX(i));
//            System.out.println("y[" + i + "]: " + obj.getY(i));

        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        DrawIt d = new DrawIt();
    }

}
