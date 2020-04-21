
public class Circulo extends Figura {

    private int radio;
//Constructores

    public Circulo() {
    }

    public Circulo(int _x, int _y, int _radio) {
        super();
        x = _x;
        y = _y;
        radio = _radio;

    }

    //Getters y Setters
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
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

    @Override
    public double Area() {

        return Math.round((radio * radio) * (Math.PI));

    }

    public String Mostrar() {

        return Circulo.class.getName() + " posicion " + getX() + " " + getY() + " lado " + getRadio() + " area " + Area();

    }

}
