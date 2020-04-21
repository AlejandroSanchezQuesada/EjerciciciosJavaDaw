package ejercicio6_9;

public class Cancion {

    private String titulo;
    private String autor;

    public Cancion() {
        titulo = "";
        autor = "";

    }

    public Cancion(String _titulo, String _autor) {
        titulo = _titulo;
        autor = _autor;

    }
    //Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setTitulo(String _titulo) {
        titulo = _titulo;
    }

    public void setAutor(String _autor) {
        autor = _autor;
    }

    public String toString2() {
        String datos = "El titulo de la cancion: " + getTitulo() + "\n El Autor " + getAutor();
        return datos;
    }

}
