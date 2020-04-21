package bloque79;

import java.util.Scanner;

public class Bloque79 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        String a[] = new String[cadena.length()];

        System.out.println(cadena);
        System.out.println(" ");

        for (int i = 0; i < a.length; i++) {
            a = cadena.split(" ");
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }

    }

}
