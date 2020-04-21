package bloque85;

import java.util.Scanner;

public class Bloque85 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vidas = 6;

        System.out.println("Introduzca palabra secreta");
        String p = sc.nextLine();
        p = p.toLowerCase();
        StringBuilder palabra = new StringBuilder(p);
        StringBuilder secreta = palabra;
        for (int i = 0; i < secreta.length(); i++) {
            secreta.setCharAt(i, '-');
        }//fin for

        for (int i = vidas; i >= 0; i--) {

            System.out.println(secreta);
            System.out.println("Vidas Restantes " + i);
            System.out.println("Introduzca letra");
            String intento = sc.nextLine();
            intento = intento.toLowerCase();

            for (int j = 0; j < secreta.length(); j++) {

                if (intento.charAt(0) == (p.charAt(j))) {
                    secreta.setCharAt(j, p.charAt(j));

                }
                if (p.equals(secreta.toString())) {
                    System.out.println("HAS GANADO");
                    i = 0;
                }

            }
            if (i == 0) {
                System.out.println("Vidas Perdidas");
                System.out.println("HAS PERDIDO");
            }

        }

    }

}
