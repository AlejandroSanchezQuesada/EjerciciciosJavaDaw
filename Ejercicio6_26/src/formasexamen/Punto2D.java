package formasexamen;

public class Punto2D extends Punto implements Movible {
   
    private int x;
    private int y;
//Constructores
    public Punto2D() {
    }

    public Punto2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Punto2D(Punto2D p) {
    }
//Getters y Setters

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
//ToString

    @Override
    public String toString() {
        return super.toString()+ "X "+x+" Y "+y;
    }
    
//Metodos

    public double distancia(Punto2D p){
    return Math.hypot(p.x - x, p.y - y);
    }
    
    
    
    public void mover(int dx, int dy){
     x = dx;
     y = dy;
    
    }
    
    
    
    
    
    
    
    
}
