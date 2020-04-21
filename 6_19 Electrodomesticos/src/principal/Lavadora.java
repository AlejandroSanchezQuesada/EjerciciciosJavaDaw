package principal;

public class Lavadora extends Electrodomestico {

    private int carga;

    //Constructores
    public Lavadora() {
        carga = 5;

    }

    public Lavadora(float _precio, float _peso) {
        super();
        carga = 5;
        precio = _precio;
        peso = _peso;
    }

    public Lavadora(float precio, String color, char consumoenergetico, float peso, int _carga) {
        super();

        this.precio = precio;
        this.color = color;
        this.consumoenergetico = consumoenergetico;
        this.peso = peso;

        carga = _carga;

    }
//Getters y Setters

    public int getCarga() {
        return carga;
    }

//Metodos
    public float precioFinal() {
        super.precioFinal();
        if (carga > 30) {
            precio = precio + 30;
        }
        return precio;

    }

    public String toString() {
        return "Electrodomestico{" + "precio=" + precioFinal() + ", color=" + color + ", consumoenergetico=" + consumoenergetico + ", peso=" + peso + "carga = " + carga;
    }

}
