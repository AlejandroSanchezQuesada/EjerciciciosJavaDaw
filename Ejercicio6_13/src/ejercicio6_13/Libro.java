package ejercicio6_13;

public class Libro {

    private String ISBN;
    private String Titulo;
    private String Autor;
    private int NumPag;

    public Libro(String _Titulo, String _Autor, String _ISBN, int _NumPag) {
        ISBN = _ISBN;
        Titulo = _Titulo;
        Autor = _Autor;
        NumPag = _NumPag;

    }

    public String toString2() {
        String r = Autor + "ha escrito el libro " + Titulo + " con ISBN " + ISBN + " y con " + NumPag + " paginas";

        return r;
    }

}
