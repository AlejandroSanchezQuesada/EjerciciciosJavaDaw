
public class Cuadrado extends Figura {

    private int lado;

    public Cuadrado() {
    }

    public Cuadrado(int _x, int _y, int _lado) {
        super();

        x = _x;
        y = _y;
        lado = _lado;

    }
//Getters y Setters

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

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

    //Metodos
    @Override
    public double Area() {
        return Math.round(lado * lado);

    }

    public String Mostrar() {

        return Cuadrado.class.getName() + " posicion " + getX() + " " + getY() + " lado " + getLado() + " areaIndividual " + Area();

    }

}
