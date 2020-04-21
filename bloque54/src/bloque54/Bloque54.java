package bloque54;

import java.util.Scanner;

public class Bloque54 {

    static void desplazaN(int a[], int desplaza) {
        for (int i = 0; i < desplaza; i++) {
            int ultimo = a[a.length - 1];
            int tamano = a.length;
            for (int j = tamano - 1; j >= 1; j--) {
                a[j] = a[j - 1];

            }//fin for
            a[0] = ultimo;

        }//fin for

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int desplaza;
        int a[] = new int[20];

        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100) + 1;
        } //fin for

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }//fin for

        System.out.println(" ");//espacio blanco
        try {
            System.out.println("INTRODUZCA EL DESPLAZAMIENTO");
            desplaza = sc.nextInt();

            desplazaN(a, desplaza);

        } catch (Exception e) {

            System.out.println("HAS PUESTO ALGO MAL SEGURO");
        }

    }

}
