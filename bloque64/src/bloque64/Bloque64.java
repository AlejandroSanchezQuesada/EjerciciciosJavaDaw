package bloque64;

import java.util.Scanner;

public class Bloque64 {

    static void alumnosFila(String a[][], int fila) {
        int sitios = 0;
        if (fila == 0) {
            sitios = 3;
        } else if (fila == 1) {
            sitios = 3;
        } else if (fila == 2) {
            sitios = 5;
        } else if (fila == 3) {
            sitios = 6;
        }

        for (int i = 0; i <= sitios; i++) {
            System.out.print(a[fila][i] + " ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fila;

        String[][] a = {
            {"Juanjo", "Rodenas", "Jose", "Victor"},
            {"Gabor", "Jonny", "Olga", "Sergio"},
            {"Jorge", "Mathi", "Mario", "Alex", "Hector", "Marcos"},
            {"Mike", "Alfonso", "Alexander", "Diego", "Montalvo", "Jeff", "Santi"}

        };//fin array

        try {
            do {
                System.out.println("Introduce una fila del 1 al 4");
                fila = sc.nextInt();
                alumnosFila(a, fila - 1);
            } while (fila != 1 && fila != 2 && fila != 3 && fila != 4);
        } catch (Exception e) {

            System.out.println("HA OCURRIDO UN ERROR ");
        }

    }//fin main

}
