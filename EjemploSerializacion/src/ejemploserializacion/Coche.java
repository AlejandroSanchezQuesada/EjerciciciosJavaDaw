package ejemploserializacion;

import java.io.Serializable;

public class Coche implements Serializable {

    private String marca;
    private String modelo;
    private String matricula;
    private int anyo_matriculacion;

//Constructor
    public Coche(String marca, String modelo, String matricula, int anyo_matriculacion) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.anyo_matriculacion = anyo_matriculacion;
    }
//Getters y Setters

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnyo_matriculacion() {
        return anyo_matriculacion;
    }

    public void setAnyo_matriculacion(int anyo_matriculacion) {
        this.anyo_matriculacion = anyo_matriculacion;
    }

//Metodos 
    @Override
    public String toString() {
        return "Coche{" + "marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + ", anyo_matriculacion=" + anyo_matriculacion + '}';
    }

}
