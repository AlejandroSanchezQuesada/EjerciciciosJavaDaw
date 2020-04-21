package examen1;

public class Rectangulo {

    private Punto PuntoIzqda = new Punto();
    private Punto PuntoDerecha = new Punto();

    public Rectangulo() {
        PuntoIzqda.setCordenadaY(0);
        PuntoIzqda.setCordenadaX(0);

        PuntoDerecha.setCordenadaY(10);
        PuntoDerecha.setCordenadaX(10);

    }

    public Rectangulo(int Izqda1, int Izqda2, int Derec1, int Derec2) {
        PuntoIzqda.setCordenadaY(Izqda1);
        PuntoIzqda.setCordenadaX(Izqda2);

        PuntoDerecha.setCordenadaY(Derec1);
        PuntoDerecha.setCordenadaX(Derec2);

    }

    //metodos
    public void Dibuja() {
        int Primero = Math.abs(PuntoIzqda.getCordenadaY() - PuntoDerecha.getCordenadaY());
        int Segundo = Math.abs(PuntoIzqda.getCordenadaX() - PuntoDerecha.getCordenadaX());

        for (int i = 0; i < Primero; i++) {
            for (int j = 0; j < Segundo; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public int Area() {

        int base = PuntoIzqda.getCordenadaX();
        int altura = PuntoDerecha.getCordenadaY();

        return base * altura;

    }

}
