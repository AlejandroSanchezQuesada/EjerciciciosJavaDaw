package ejercicio6_12;

import java.util.Scanner;

public class Ejercicio6_12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hora pipo = new Hora();
        pipo.deSegundos(1000);
        System.out.println(pipo.toString2());

        Hora parte2 = new Hora();
        parte2.Leer();
        parte2.siguiente();
        System.out.println(parte2.toString2());

        System.out.println(parte2.segundosDesde(0, 0, 0));

        System.out.println(parte2.igualQue(pipo.getHora(), pipo.getMinutos(), pipo.getSegundos()));
    }

}
