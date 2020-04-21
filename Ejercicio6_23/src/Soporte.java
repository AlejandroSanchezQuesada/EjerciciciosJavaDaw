
public abstract class Soporte {

    protected String titulo;
    protected int numero;
    protected float precio;

    //Constructores
    public Soporte() {
    }

    public Soporte(String titulo, int numero, float precio) {
        this.titulo = titulo;
        this.numero = numero;
        this.precio = precio;
    }

    //Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    //Metodos
    public float damePrecioSinIVA() {
        return getPrecio();
    }

    public float damePrecioConIVA() {
        return getPrecio() + (getPrecio() * 21) / 100;

    }

    public abstract String imprimeDatos();

}
