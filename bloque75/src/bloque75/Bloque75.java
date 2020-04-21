package bloque75;

import java.util.Scanner;

public class Bloque75 {

    static void remplaza(String cadena, String vocales) {
        cadena = cadena.toLowerCase();
        char a[] = new char[cadena.length()];
        char v[] = new char[vocales.length()];

        for (int i = 0; i < cadena.length(); i++) {
            a[i] = cadena.charAt(i);
        }//fin for

        for (int i = 0; i < vocales.length(); i++) {
            v[i] = vocales.charAt(i);
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < v.length; j++) {
                if (a[i] == v[j]) {
                    a[i] = 'a';

                }
            }
        }//fin for

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte cadena de texto");
        String cadena = sc.nextLine();
        String vocales = "aeiou";

        System.out.println(cadena);
        System.out.println(" ");
        remplaza(cadena, vocales);

    }

}
