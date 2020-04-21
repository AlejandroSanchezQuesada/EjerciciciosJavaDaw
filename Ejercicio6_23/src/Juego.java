
public class Juego extends Soporte {

    private String consola;
    private int minJugadores;
    private int maxJugadores;

    public Juego(String consola, int minJugadores, int maxJugadores) {
        this.consola = consola;
        this.minJugadores = minJugadores;
        this.maxJugadores = maxJugadores;
    }

    public Juego(String titulo, int numero, float precio, String consola, int minJugadores, int maxJugadores) {
        super(titulo, numero, precio);
        this.consola = consola;
        this.minJugadores = minJugadores;
        this.maxJugadores = maxJugadores;
    }
    
    
    
    
    

    public String imprimeDatos() {

        return getClass().getName()+" "+getTitulo() + "; numero: " + getNumero() + "; precio: " + getPrecio() + " consola : " + consola + " minJugadores : " + minJugadores + " maxJugadores :" + maxJugadores;

    }

}
