package ejercicio6_10;

import java.util.LinkedList;

public class Coche {

    private String marca;
    private String modelo;
    private float ancho;
    private float largo;
    private float tamMaletero5plazas;
    private float tamMaletero7plazas;
    private int numIsodix;
    private float precio;
    private final String combustible[] = new String[]{"Diesel", "Gasolina", "Hibrido"};
    private String combusEleccion = "";
    private final String tipoCambio[] = new String[]{"Manual", "Automatico"};
    private String cambioEleccion = "";

    //Constructores Defecto y Normal
    public Coche() {
        marca = "";
        modelo = "";
        ancho = 0f;
        largo = 0f;
        tamMaletero5plazas = 0;
        tamMaletero7plazas = 0;
        numIsodix = 0;
        precio = 0;
        combusEleccion = combustible[0].toString();
        cambioEleccion = tipoCambio[0];

    }

    public Coche(String marca, String modelo, float ancho, float largo, float tamMaletero5plazas, float tamMaletero7plazas, int numIsodix, float precio, String combusEleccion, String cambioEleccion) {
        this.marca = marca;
        this.modelo = modelo;
        this.ancho = ancho;
        this.largo = largo;
        this.tamMaletero5plazas = tamMaletero5plazas;
        this.tamMaletero7plazas = tamMaletero7plazas;
        this.numIsodix = numIsodix;
        this.precio = precio;
        this.combusEleccion = combusEleccion;
        this.cambioEleccion = cambioEleccion;

    }

    //Getters y Setters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public float getAncho() {
        return ancho;
    }

    public float getLargo() {
        return largo;
    }

    public float getTamMaletero5plazas() {
        return tamMaletero5plazas;
    }

    public float getTamMaletero7plazas() {
        return tamMaletero7plazas;
    }

    public int getNumIsodix() {
        return numIsodix;
    }

    public float getPrecio() {
        return precio;
    }

    public String getCombusEleccion() {
        return combusEleccion;
    }

    public String getCambioEleccion() {
        return cambioEleccion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    public void setTamMaletero5plazas(float tamMaletero5plazas) {
        this.tamMaletero5plazas = tamMaletero5plazas;
    }

    public void setTamMaletero7plazas(float tamMaletero7plazas) {
        this.tamMaletero7plazas = tamMaletero7plazas;
    }

    public void setNumIsodix(int numIsodix) {
        this.numIsodix = numIsodix;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setCombusEleccion(String combusEleccion) {
        this.combusEleccion = combusEleccion;

    }

    public void setCambioEleccion(String cambioEleccion) {
        this.cambioEleccion = cambioEleccion;

    }

    //Metodo toString
    public String toString2() {
        return "Coche{" + "marca=" + marca + ", modelo=" + modelo + ", ancho=" + ancho + ", largo=" + largo + ", tamMaletero5plazas=" + tamMaletero5plazas + ", tamMaletero7plazas=" + tamMaletero7plazas + ", numIsodix=" + numIsodix + ", precio=" + precio + ", combustible=" + combusEleccion + ", tipoCambio=" + cambioEleccion + '}';
    }

    //Metodos
    public boolean cabeEnCochera(int anchoCochera, int largoCochera) {
        return this.ancho < anchoCochera && this.largo < largoCochera;

    }

    public boolean esValido(int anchoCochera, int largoCochera, float precioCoche) {
        return this.ancho < anchoCochera && this.largo < largoCochera && precioCoche <= this.precio;

    }

    public int nota() {
        int nota = 0;

        if (tamMaletero5plazas > 500) {
            nota++;
        }
        if (tamMaletero7plazas > 200) {
            nota++;
        }
        if (combusEleccion.equals("Diesel")) {
            nota++;
        }
        if (cambioEleccion.equals("Automatico")) {
            nota++;
        }
        for (int i = 0; i < this.numIsodix; i++) {
            nota++;
        }

        return nota;
    }

    public static Coche mejorOpcion(LinkedList<Coche> ListaCoches) {
        int puntmax = 0;
        int posicion = 0;
        for (int i = 0; i < ListaCoches.size(); i++) {

            if (ListaCoches.get(i).nota() > puntmax) {

                puntmax = ListaCoches.get(i).nota();
                posicion = i;

            }
        }

        return ListaCoches.get(posicion);

    }

}
