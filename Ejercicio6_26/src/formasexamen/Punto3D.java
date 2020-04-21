package formasexamen;

public class Punto3D extends Punto{
    
    private int x;
    private int y;
    private int z;
//Constructores
    public Punto3D() {
    }

    public Punto3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Punto3D(Punto3D p) {
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

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
           
 //ToString

    @Override
    public String toString() {
        return super.toString()+ "X "+x+" Y "+y+" Z"+z;
    }
    
//Metodos

    public double distancia(Punto3D p){
        int distancia;
      distancia = ((p.x - x) + (p.y - y) + (p.z - z));
      return Math.sqrt(distancia);
    }
    
    
    
}
