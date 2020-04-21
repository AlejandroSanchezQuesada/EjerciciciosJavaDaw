package bloque81;

import java.util.Scanner;

public class Bloque81 {

    static void espejo(String c) {

        for (int i = c.length() - 1; i >= 0; i--) {
            System.out.print(c.charAt(i));
        }

    }

    static void normal(String c) {
        for (int i = 0; i < c.length() - 1; i++) {
            System.out.print(c.charAt(i));
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca cadena");
        String cadena = sc.nextLine();

        normal(cadena);
        espejo(cadena);

    }

}
