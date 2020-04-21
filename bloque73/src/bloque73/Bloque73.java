package bloque73;

import java.util.Scanner;

public class Bloque73 {

    public static void main(String[] args) {
        String stan = "StanLee";
        stan = stan.toLowerCase();
        int pasastan = 0;
        int contstan = 0;
        int contdef = 0;

        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        cadena = cadena.toLowerCase();

        for (int i = 0; i < cadena.length(); i++) {
            for (int j = pasastan; j < stan.length(); j++) {
                if (stan.charAt(j) == cadena.charAt(i)) {
                    pasastan++;
                    contstan++;
                }

                if (contstan == stan.length()) {
                    contdef++;
                    contstan = 0;
                    pasastan = 0;
                }

            }

        }
        System.out.println(contdef);

    }//fin main

}
