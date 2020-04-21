
public abstract class Figura {

    protected int x;
    protected int y;

    public Figura() {
    }

    public Figura(int _x, int _y) {

        x = _x;
        y = _y;

    }

    public abstract double Area();

    public abstract String Mostrar();

}
