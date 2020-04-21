package ejercicio6_7;

public class Ejercicio6_7 {

    public static void main(String[] args) {
        int turno = 1;
        TresEnRaya juego = new TresEnRaya();

        juego.DibujaTablero();

        while (juego.QuedanMovimientos() && !juego.GanaJugador() && !juego.GanaOrdenador()) {
            if (turno == 1) {
                juego.MueveJugador();
                turno = 2;
            } else {
                juego.MueveOrdenador();
                turno = 1;
            }
            juego.DibujaTablero();

        }
        if (juego.GanaJugador()) {
            System.out.println("Gana Jugador");
        } else if (juego.GanaOrdenador()) {
            System.out.println("Gana Ordenador");
        } else {
            System.out.println("Empatados");
        }

    }

}
