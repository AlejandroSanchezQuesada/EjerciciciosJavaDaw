
import java.io.Serializable;

public class Persona implements Serializable{
    
    private String nif;
    private String nombre;
    private String apellidos;
    private String profesion;
    private int edad;

    public Persona() {
    }

    
    public Persona(String nif, String nombre, String apellidos) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    
    
    
    

    public Persona(String nif, String nombre, String apellidos, String profesion, int edad) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.profesion = profesion;
        this.edad = edad;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", profesion=" + profesion + ", edad=" + edad + '}';
    }
    
    
    
    
    
}
