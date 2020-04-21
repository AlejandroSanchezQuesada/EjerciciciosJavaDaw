/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializarobjetos;

import java.io.Serializable;

/**
 *
 * @author jose
 */
public class Alumno implements Serializable{
    String nombre;
    String apellidos;
    int edad;
    
    public Alumno(String nombre, String apellidos, int edad){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.edad=edad;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + '}';
    }

    public Alumno() {
    }


}
