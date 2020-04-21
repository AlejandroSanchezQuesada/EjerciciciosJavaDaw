package bloque59;

import java.util.Scanner;

public class Bloque59 {

    static int[][] generaArray(int ancho, int alto) {

        int a[][] = new int[ancho][alto];
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {

                a[i][j] = (int) (Math.random() * 100) + 1;

            }//fin for anidado
        }//fin for 

        return a;

    }//fin funcion generaArray

    static void muestraArray(int a[][]) {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.printf("[%d,%d]: %02d\t", i, j, a[i][j]);
            }
        }

    }//fin funcion muestraArray

    static void sumaArray(int a[][], int a2[][]) {

        int a3[][] = new int[a.length][a.length];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                a3[i][j] = a[i][j] + a2[i][j];
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.printf("[%d,%d]: %02d\t", i, j, a3[i][j]);
            }
        }

    }

    public static void main(String[] args) {
        int ancho =6, alto =6;


        int a[][] = generaArray(ancho, alto);
        muestraArray(a);

        System.out.println(" ");
        int a2[][] = generaArray(ancho, alto);
        muestraArray(a2);
        System.out.println(" ");
        sumaArray(a, a2);

    }

}
