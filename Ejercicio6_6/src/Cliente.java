
import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private String dni;
     ArrayList<String> ListaAlquiler = new ArrayList();

    //Constructores
    public Cliente() {
        nombre = "";
        dni = "";

    }

    public Cliente(String _nombre, String _dni) {
        nombre = _nombre;
        dni = _dni;

    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    //Metodos
    public void Alquilar(String nueva) {
        ListaAlquiler.add(nueva);
    }

    public void Devolver(String quitar) {
        ListaAlquiler.remove(quitar);
    }
    
 
    

    public String MostrarPelisAlquiladas() {
        String r = "";
        for (int i = 0; i < ListaAlquiler.size(); i++) {
            r +=" \n " + ListaAlquiler.get(i);
        }

        return r;
    }

    public String toString2() {

        return getNombre();

    }

}
