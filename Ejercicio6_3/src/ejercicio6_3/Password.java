package ejercicio6_3;

import static java.lang.Math.random;
import java.nio.charset.Charset;
import java.util.Random;

public class Password {

    //Atributos
    private int longitud;
    private String contrasena;

    //Variables para contraseña
    private final String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String minusculas = "abcdefghijklmnopqrstuvwxyz";
    private final String numeros = "0123456789";
    private final String especiales = "!@#$%^&*_=+-/";

    //Setters y Getters
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getLongitud() {

        return this.longitud;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    //Constructores
    public Password() {
        this.longitud = 8;
        this.contrasena = generarPassword(this.longitud);

    }

    public Password(int longitud) {
        this.longitud = longitud;
        this.contrasena = generarPassword(this.longitud);
    }

    //Metodos
    public String generarPassword(int longitud) {
        this.longitud = longitud;
        String contrasena = "";

        for (int i = 0; i < this.longitud; i++) {
            int seleccion = (int) (Math.random() * 4);
            if (seleccion == 0) {
                int eleccion = (int) (Math.random() * this.mayusculas.length());
                contrasena = contrasena + this.mayusculas.charAt(eleccion);
            } else if (seleccion == 1) {
                int eleccion = (int) (Math.random() * this.minusculas.length());
                contrasena = contrasena + this.minusculas.charAt(eleccion);
            } else if (seleccion == 2) {
                int eleccion = (int) (Math.random() * this.numeros.length());
                contrasena = contrasena + this.numeros.charAt(eleccion);
            } else if (seleccion == 3) {
                int eleccion = (int) (Math.random() * this.especiales.length());
                contrasena = contrasena + this.especiales.charAt(eleccion);
            }

        }//fin for
        return contrasena;

    }//Fin generaContrasena

    public boolean EsFuerte() {
        boolean fuerte = false;
        int mayus = 0;
        int minus = 0;
        int numeritos = 0;
        int especiales = 0;

        for (int i = 0; i < this.longitud; i++) {
            for (int j = 0; j < this.mayusculas.length(); j++) {
                if (this.contrasena.charAt(i) == this.mayusculas.charAt(j)) {
                    mayus++;
                }
            }
            for (int j = 0; j < this.minusculas.length(); j++) {
                if (this.contrasena.charAt(i) == this.minusculas.charAt(j)) {
                    minus++;
                }
            }
            for (int j = 0; j < this.numeros.length(); j++) {
                if (this.contrasena.charAt(i) == this.minusculas.charAt(j)) {
                    numeritos++;
                }
            }
            for (int j = 0; j < this.especiales.length(); j++) {
                if (this.contrasena.charAt(i) == this.especiales.charAt(j)) {
                    especiales++;
                }
            }

        }

        if (mayus > 2 && minus > 1 && numeritos > 5) {
            fuerte = true;
        } else if (especiales > 3) {
            fuerte = true;
        }

        return fuerte;
    }

}
