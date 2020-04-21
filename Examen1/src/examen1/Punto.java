package examen1;

public class Punto {

    private int CordenadaY;
    private int CordenadaX;

//Constructores    
    public Punto() {
        CordenadaY = 0;
        CordenadaX = 0;

    }

    public Punto(int _CordenadaY, int _CordenadaX) {

        CordenadaY = _CordenadaY;
        CordenadaX = _CordenadaX;

    }

//Metodos
    public int getCordenadaY() {
        return CordenadaY;
    }

    public void setCordenadaY(int CordenadaY) {
        this.CordenadaY = CordenadaY;
    }

    public int getCordenadaX() {
        return CordenadaX;
    }

    public void setCordenadaX(int CordenadaX) {
        this.CordenadaX = CordenadaX;
    }

    public void desplaza(int _CordenadaY, int _CordenadaX) {

        CordenadaY = CordenadaY + _CordenadaY;
        CordenadaX = CordenadaX + _CordenadaX;

    }

}
