package principal;

public class Electrodomestico {

    protected float precio;
    protected String color;
    protected char consumoenergetico;
    protected float peso;
    protected String colores[] = {"blanco", "negro", "rojo", "azul", "gris"};
    protected char consumorango[] = {'A', 'B', 'C', 'D', 'E', 'F'};

//Constructores
    public Electrodomestico() {
        color = "blanco";
        consumoenergetico = 'F';
        precio = 100;
        peso = 5;
    }

    public Electrodomestico(float _precio, float _peso) {
        precio = _precio;
        peso = _peso;
    }

    public Electrodomestico(float precio, String color, char consumoenergetico, float peso) {
        this.precio = precio;
        this.color = color;
        this.consumoenergetico = consumoenergetico;
        this.peso = peso;
    }
//Getters y Setters

    public float getPrecio() {
        return precioFinal();
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumoenergetico() {
        return consumoenergetico;
    }

    public void setConsumoenergetico(char consumoenergetico) {
        this.consumoenergetico = consumoenergetico;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

//Metodos
    public void comprobarConsumoEnergetico(char _letra) {
        char aux = _letra;
        char cont = 0;
        for (int i = 0; i < consumorango.length; i++) {

            if (_letra != consumorango[i]) {
                cont++;
            }
        }
        if (cont == consumorango.length) {
            consumoenergetico = 'F';
        } else {
            consumoenergetico = aux;

        }

    }

    //  blanco, negro, rojo, azul y gris
    public void comprobarColor(String _color) {
        String aux = _color;
        char cont = 0;

        for (int i = 0; i < colores.length; i++) {
            if (!_color.equals(colores[i])) {
                cont++;
            }
            if (cont == colores.length) {
                color = "blanco";
            } else {
                color = aux;
            }

        }

    }

    public float precioFinal() {
        if (getConsumoenergetico() == 'A') {
            precio = precio + 100;
        } else if (getConsumoenergetico() == 'B') {
            precio = precio + 80;
        } else if (getConsumoenergetico() == 'C') {
            precio = precio + 60;
        } else if (getConsumoenergetico() == 'D') {
            precio = precio + 50;
        } else if (getConsumoenergetico() == 'E') {
            precio = precio + 30;
        } else {
            precio = precio + 10;
        }
//------------------------------------------

        if (getPeso() >= 0 && getPeso() <= 19) {
            precio = precio + 10;
        } else if (getPeso() >= 20 && getPeso() <= 49) {
            precio = precio + 50;
        } else if (getPeso() >= 50 && getPeso() <= 79) {
            precio = precio + 80;
        } else if (getPeso() >= 80) {
            precio = precio + 100;
        }
        return precio;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" + "precio=" + precio + ", color=" + color + ", consumoenergetico=" + consumoenergetico + ", peso=" + peso + '}';
    }

}
