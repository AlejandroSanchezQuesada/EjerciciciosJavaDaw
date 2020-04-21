package bloque74;

import java.util.Scanner;

public class Bloque74 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cont = 0;

        System.out.println("Inserte cadena de texto");
        String cadena = sc.nextLine();
        cadena = cadena.toLowerCase();
        String vocales = "aeiou";

        for (int i = 0; i < cadena.length(); i++) {

            for (int j = 0; j < vocales.length(); j++) {
                if (cadena.charAt(i) == vocales.charAt(j)) {
                    cont++;
                }//fin if
            }//fin for aniddo

        }//fin for
        System.out.println("Numero de veces que hay vocales = " + cont);

    }//fin main

}
