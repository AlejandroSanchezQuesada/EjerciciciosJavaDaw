package principal;

public class Television extends Electrodomestico {

    private float pulgadas;
    private boolean TDT;

    public Television() {
        pulgadas = 20;
        TDT = false;

    }

    public Television(float _precio, float _peso) {
        super();
        precio = _precio;
        peso = _peso;
        pulgadas = 20;
        TDT = false;

    }

    public Television(float precio, String color, char consumoenergetico, float peso, float _pulgadas, boolean _TDT) {
        super();
        this.precio = precio;
        this.color = color;
        this.consumoenergetico = consumoenergetico;
        this.peso = peso;

        pulgadas = _pulgadas;
        TDT = _TDT;

    }

    //Getters y Setters
    public float getPulgadas() {
        return pulgadas;
    }

    public boolean getTDT() {
        return TDT;
    }

    public void setPulgadas(float pulgadas) {
        this.pulgadas = pulgadas;
    }

    public void setTDT(boolean TDT) {
        this.TDT = TDT;
    }

    //Metodos
    public float precioFinal() {
        super.precioFinal();

        if (getPulgadas() > 40) {
            precio = precio + precio * 0.3f;
        }
        if (TDT == true) {
            precio = precio + 50;
        }

        return precio;
    }

    public String toString() {
        return "Electrodomestico{" + "precio=" + precioFinal() + ", color=" + color + ", consumoenergetico=" + consumoenergetico + ", peso=" + peso + " pulgadas = " + pulgadas + " TDT:" + TDT;

    }

}
