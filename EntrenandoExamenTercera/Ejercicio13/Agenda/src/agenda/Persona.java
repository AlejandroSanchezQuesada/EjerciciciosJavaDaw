/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author jose
 */
public class Persona {
    String nombre;
    String apellidos;
    String telefono;

    public Persona(String nombre, String apellidos, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " - " + telefono ;
    }
    
    
}
