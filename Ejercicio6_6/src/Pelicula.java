
import java.util.ArrayList;


public class Pelicula {

    private String titulo;
    private String genero;
    private int duracion;
    private ArrayList<String>ListaDisponibles = new ArrayList();
    //Constructores
    public Pelicula() {
        titulo = "";
        genero = "";
        duracion = 0;

    }

    public Pelicula(String _titulo, String _genero) {
        titulo = _titulo;
        genero = _genero;

    }
    //Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void Disponibles(String nueva){
        ListaDisponibles.add(nueva);
    
    }
    
    public void NoDisponibles(String quitar){
        ListaDisponibles.remove(quitar);
    
    }
    
    
    
    
    
    public String toString2(){
    return ""+getTitulo();
    
    }
    
    
}
