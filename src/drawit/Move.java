/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawit;

import java.awt.Color;

/**
 *
 * @author Red Viper
 */
public class Move {

    private int x;
    private int y;
    private int tempX;
    private int tempY;

    public void move(Constants.direction direction, ObjectDrawing obj, int x, int y, Color color) {
        setX(x);
        setY(y);
        setTempX(getX());
        setTempY(getY());
        switch (direction) {
            case RIGHT:
                if (tempX < 232) {
                    moveRight(obj);
                    setX(tempX);
                    obj.setPoint(this.x,this.y,color);
                }
                break;

            case LEFT:
                if (tempX > 1) {
                    moveLeft(obj);
                    setX(tempX);
                    obj.setPoint(this.x,this.y,color);
                }                
                break;

            case UP:
                if (tempY < 231) {
                   
                    moveUp(obj);
                    setY(tempY);
                    System.out.println("here"+y);
                    obj.setPoint(this.x,this.y,color);
                }
                break;

            case DOWN:
                if (tempY > 1) {
                    moveDown(obj);
                    setY(tempY);
                    obj.setPoint(this.x,this.y,color);
                }
                break;

            case UPWARDLEFT:
                if (tempY < 231 && tempX > 1) {
                    moveUp(obj);
                    moveLeft(obj);
                    setX(tempX);
                    setY(tempY);
                    obj.setPoint(this.x,this.y,color);
                }
                break;

            case UPWARDRIGHT:
                if (tempY < 231 && tempX < 232) {
                    moveUp(obj);
                    moveRight(obj);
                    setX(tempX);
                    setY(tempY);
                    obj.setPoint(this.x,this.y,color);
                }
                break;

            case DOWNWARDLEFT:
                if (tempY > 1 && tempX > 1) {
                    moveDown(obj);
                    moveLeft(obj);
                    setX(tempX);
                    setY(tempY);
                    obj.setPoint(this.x,this.y,color);
                }
                break;

            case DOWNWARDRIGHT:
                if (tempY > 1 && tempX < 232) {
                    moveDown(obj);
                    moveRight(obj);
                    setX(tempX);
                    setY(tempY);
                    obj.setPoint(this.x,this.y,color);
                }
                break;
        }

        DrawIt.x = this.x;
        DrawIt.y = this.y;
        System.out.println(this.y);
    }

    public void setTempX(int x) {
        this.tempX = x;
    }

    public void setTempY(int y) {
        this.tempY = y;
    }

    public void moveUp(ObjectDrawing obj) {
        tempY++;
    }

    public void moveDown(ObjectDrawing obj) {
        tempY--;
    }

    public void moveLeft(ObjectDrawing obj) {
        tempX--;
    }

    public void moveRight(ObjectDrawing obj) {
        tempX++;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {    
        this.y = y;
    }

}
