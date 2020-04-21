
public class DVD extends Soporte {

    private int duracion;
    public String ListaIdiomas[] = new String[]{"Español", "Inglés"};

    public DVD(int duracion) {
        this.duracion = duracion;
    }

    public DVD(String titulo, int numero, float precio, int duracion) {
        super(titulo, numero, precio);
        this.duracion = duracion;
    }

    public String imprimeDatos() {
        String lista = "";
        for (int i = 0; i < ListaIdiomas.length; i++) {
            lista = lista + ListaIdiomas[i] + ",";
        }

        return getClass().getName() + " " + getTitulo() + "; numero: " + getNumero() + "; precio: " + getPrecio() + " duracion: " + duracion +" "+ lista;

    }

}
