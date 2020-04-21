package formasexamen;

public class Cuadrado extends Rectangulo {

    private int lado;
    
    
    public Cuadrado(){}
    
    
    public Cuadrado(Punto2D _p1, int _lado){
    super();
         p1 = _p1;
        lado = _lado;
    
    
    }
    public Cuadrado(Cuadrado c){
     
    
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    @Override
    public String toString() {
        return super.toString()+ "lado :"+lado;
    }
    
    
    
    
    
    @Override
    public void mover(int _x, int _y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
