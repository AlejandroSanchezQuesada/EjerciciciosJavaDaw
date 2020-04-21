package bloque78;

import java.util.Scanner;

public class Bloque78 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce texto");
        String cadena = sc.nextLine();
        String a[] = new String[cadena.length()];

        for (int i = 0; i < a.length; i++) {
            a = cadena.split(" ");

        }

        String aux = a[0];
        a[0] = a[a.length - 1];
        a[a.length - 1] = aux;

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

}
