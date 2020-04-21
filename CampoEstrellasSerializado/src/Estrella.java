
import java.awt.Color;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jose
 */

public class Estrella implements Serializable{
    private int x;
    private int y;
    private int velocidadX;
    private int velocidadY;
    private Color color;
    private int radio;

    public int getRadio() {
        return radio;
    }
   
    
    public Estrella(){
        x=(int)(Math.random()*Principal.ancho);
        y=(int)(Math.random()*Principal.alto);
        velocidadX=(int)(Math.random()*5)+1;
        velocidadY=(int)(Math.random()*5)+1;
        color=new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
        radio=(int)(Math.random()*50)+10;
    }

    public Estrella(int x, int y, int velocidadX,int velocidadY) {
        this.x = x;
        this.y = y;
        this.velocidadX = velocidadX;
        this.velocidadY = velocidadY;
    }

    public int getX() {
        return x;
    }

    public int getVelocidadX() {
        return velocidadX;
    }
    public int getVelocidadY() {
        return velocidadY;
    }

    public int getY() {
        return y;
    }
    public void mover(){
        if (x+velocidadX>Principal.ancho || x+velocidadX<0)
            velocidadX=velocidadX*(-1);
        else
             x=x+velocidadX;
        if (y+velocidadY>Principal.alto || y+velocidadY<0)
            velocidadY=velocidadY*(-1);
        else
            y=y+velocidadY;
        
    }
    public void masVelocidad(){
        if (velocidadX==0)
            velocidadX=1;
        if (velocidadY==0)
            velocidadY=1;
        velocidadX=velocidadX*2;
        velocidadY=velocidadY*2;
    }
    public void menosVelocidad(){
        velocidadX=velocidadX/2;
        velocidadY=velocidadY/2;
    }

    public Color getColor() {
        return color;
    }
    
}
