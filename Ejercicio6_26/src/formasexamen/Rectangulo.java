package formasexamen;

public class Rectangulo implements Movible {

    protected int base;
    protected int altura;
    protected Punto2D p1;

//Constructores
    public Rectangulo() {
        p1 = new Punto2D(0, 0);
        base = 1;
        altura = 2;

    }

    public Rectangulo(Punto2D p1, int base, int altura) {
        this.base = base;
        this.altura = altura;
        this.p1 = p1;
    }

    public Rectangulo(Rectangulo r) {
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Punto2D getP1() {
        return p1;
    }

    public void setP1(Punto2D p1) {
        this.p1 = p1;
    }

    @Override
    public String toString() {
        return "Rectangulo{" + "p1=" + p1 + '}';
    }

    public void mover(int dx, int dy) {
        p1.setX(dx);
        p1.setY(dy);
    }
    
    public int area(){
    return base * altura;
    
    
    }
    
    
}
