package bloque76;

import java.util.Scanner;

public class Bloque76 {

    static void inviertecadena(String cadena) {

        for (int i = cadena.length() - 1; i >= 0; i--) {
            System.out.print(cadena.charAt(i));
        }

    }//fin funcion inviertecadena

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca la cadena");
        String cadena = sc.nextLine();
        cadena = cadena.toLowerCase();
        System.out.println(cadena);
        inviertecadena(cadena);

    }

}
