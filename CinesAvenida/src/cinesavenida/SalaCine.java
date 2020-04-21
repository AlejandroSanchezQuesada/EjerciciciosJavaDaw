package cinesavenida;

public class SalaCine {
    private String nombreSala;
    private int aforo;
    private int ocupadas;
    private String pelicula;
    private float entrada;

    //Constructores
    public SalaCine() {
        nombreSala = "";
        aforo = 100;
        ocupadas = 0;
        pelicula = "";
        entrada = 5.00f;

    }

    public SalaCine(String _nombreSala,String _pelicula, float _entrada, int _aforo, int _ocupadas) {
        nombreSala = _nombreSala;
        pelicula = _pelicula;
        entrada = _entrada;
        aforo = _aforo;
        ocupadas = _ocupadas;

    }

    //Getters y Setters
    public void setAforo(int _aforo) {
        aforo = _aforo;

    }

    public void setOcupadas(int _ocupadas) {
        ocupadas = _ocupadas;
    }

    public void setLibres(int _libres) {
        ocupadas = aforo - _libres;

    }

    public void setPelicula(String _pelicula) {
        pelicula = _pelicula;

    }

    public void setEntrada(float _entrada) {
        entrada = _entrada;

    }
    
     public void setNombreSala(String _nombreSala) {
        nombreSala = _nombreSala;
    }

    public int getAforo() {

        return aforo;
    }

    public int getOcupadas() {
        return ocupadas;
    }

    public String getPeliculas() {
        return pelicula;
    }

    public int getLibres() {
        return aforo - ocupadas;
    }

    public float getPorcentaje() {
        return (100 * (float) ocupadas) / ((float) aforo);
    }

    public float getIngresos() {
        return ocupadas * entrada;
    }

    public String getPelicula() {
        return pelicula;
    }

    public float getEntrada() {
        return entrada;
    }

    public void getVaciar() {
        ocupadas = 0;
        pelicula = "";

    }

   

    public void entraUno() {
        ocupadas++;
    }

    public String toString2() {
        return "SalaCine{" +"\n Nombre Sala = "+nombreSala + "\n aforo=" + aforo + ",\n ocupadas=" + ocupadas + ", \n pelicula=" + pelicula + ", \n entrada=" + entrada + '}';
    }

}
