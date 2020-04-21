package bloque80;

import java.util.Scanner;

public class Bloque80 {

    static void cuentaletras(String c) {
        int cont = 0;
        for (int i = 0; i < c.length(); i++) {
            cont++;
        }

        if (cont < 5) {

            System.out.println("La cadena introducida tiene menos de 5 caracteres");

        } else if (cont >= 5 && cont <= 15) {
            System.out.print("La cadena introducida tiene entre 5 y 15 caracteres");
        } else {
            System.out.print("La cadena introducida tiene más de 15 caracteres");
        }

    }

    static void acabaEn(String c) {
        int t = c.length() - 1;
        if (c.charAt(t) == 'a') {
            System.out.print(" y termina por a ");
        } else if (c.charAt(t) == 'A') {
            System.out.print(" y termina por A ");
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String cadena = sc.nextLine();

        cuentaletras(cadena);
        acabaEn(cadena);

    }

}
