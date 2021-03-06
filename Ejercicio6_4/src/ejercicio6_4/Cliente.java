package ejercicio6_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    private String nombre;
    private String dni;
    private ArrayList<CuentaBancaria> ListaCuentas;

    Scanner sc = new Scanner(System.in);

    //Contructor 
    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        ListaCuentas = new ArrayList();
    }

    //Getters y Setters
    public String getNombre() {
        return this.nombre;
    }

    public String getDni() {
        return this.dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    //Metodos
    public void NuevaCuenta(CuentaBancaria c) {
       
        ListaCuentas.add(c);

    }

    public String toString2() {
        String datos;
        datos = this.nombre + "\n Dni : " + getDni();
        for (int i = 0; i < ListaCuentas.size(); i++) {
            CuentaBancaria cb = ListaCuentas.get(i);
            datos = datos + "\n" + cb.toString2();

        }
        return datos;
    }

}
