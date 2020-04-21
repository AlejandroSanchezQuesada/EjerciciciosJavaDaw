package primerpoo;

public class Pokemon {

    private int vida;
    private int ataque;
    private String nombre;
    public static int max_ataques = 4;

    public Pokemon(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;

    }

    public Pokemon() {
        this.nombre = "NombreVacio";
        this.vida = 5;
        this.ataque = 1;

    }//Con parametros vacios este seria el valor por defecto

    public int getVida() {
        return vida;
    }

    public void setVida(int nueva_vida) {
        this.vida = nueva_vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void estado() {
        System.out.println("Nombre " + nombre);
        System.out.println("Vida " + vida);
        System.out.println("Ataque " + ataque);
        System.out.println("Max.Ataques " + max_ataques);

    }

}
