package bloque82;

import java.util.Scanner;

public class Bloque82 {

    static void subMayus(String c1, String c2) {

        String a1[] = c1.split(" ");
        String a2[] = c2.split(" ");

        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {

                if (a1[i].equals(a2[j])) {
                    a1[i] = a1[i].toUpperCase();
                }//fin if

            }//fin for
        }//fin for

        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca cadena 1");
        String c1 = sc.nextLine();
        System.out.println("Introduzca cadena 2");
        String c2 = sc.nextLine();

        System.out.println("Primera cadena");
        System.out.println(c1);
        System.out.println("Segunda cadena");
        System.out.println(c2);
        System.out.println("Tercera cadena");
        subMayus(c1, c2);

    }

}
