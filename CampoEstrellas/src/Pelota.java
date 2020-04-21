
import java.awt.Color;

public class Pelota {

    private int x;
    private int y;
    private int radio;
    private Color color;
    private int velocidadBola;
    private boolean maxX = false;
    private boolean maxY = false;

    public Pelota(int x, int y, int radio, Color color, int velocidadBola) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.color = color;
        this.velocidadBola = velocidadBola;
    }

    public Pelota(int x, int y, int radio, Color color, int velocidadBola, boolean maxX, boolean maxY) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.color = color;
        this.velocidadBola = velocidadBola;
        this.maxX = maxX;
        this.maxY = maxY;

    }

    public Pelota() {
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

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getVelocidadBola() {
        return velocidadBola;
    }

    public void setVelocidadBola(int velocidadBola) {
        this.velocidadBola = velocidadBola;
    }

    public boolean isMaxX() {
        return maxX;
    }

    public void setMaxX(boolean maxX) {
        this.maxX = maxX;
    }

    public boolean isMaxY() {
        return maxY;
    }

    public void setMaxY(boolean maxY) {
        this.maxY = maxY;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + radio + " " + color + " " + velocidadBola + " " + maxX + " " + maxY;
    }

}
