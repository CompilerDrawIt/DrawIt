/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawit;

/**
 *
 * @author theresa
 */
public class atTheLeftOf {
    Integer i;
    public int x3;
    public int y3;
    int holdY,holdX,x1,x2;
    
    public void AtTheLeftOf(ObjectDrawing obj, ObjectDrawing objN){
        holdY=obj.getSizeY();
        holdX=obj.getSize();
        this.y3=(obj.getY(0))-1;
        System.out.println("holdY: " +holdY);
        System.out.println("holdX: " +holdX);
        System.out.println("name niya: "+obj.getObjectName());
        for(i=0;i<=holdY-1;i++){
            x1 = obj.getY(i);
            if(y3>=x1){
                y3=x1;
            }else{
                y3=y3;
            }
        }
        System.out.println("y3: "+y3);
        this.x3 = obj.getX(0);
        for(i=0;i<=holdX-1;i++){
            x1 = obj.getX(i);
            if(x3>=x1){
                x3=x1;
            }else{
                x3=x3;
            }
        }
        
        System.out.println("x3: "+x3);
        y3=y3;
        x3=x3;
        //objN.addX(this.x3);
        //objN.addY(this.y3);
        //DrawIt.x = this.x3;
        //DrawIt.y = this.y3;
        System.out.println("size of labX: "+objN.getSize());
        System.out.println("size of labY: "+objN.getSizeY());
        for(int o=0;o<objN.getSize();o++){
            System.out.println("x: "+objN.getX(o));
        }
        for(int o=0;o<objN.getSizeY();o++){
            System.out.println("y: "+objN.getY(o));
        }
        
    }
    
}

