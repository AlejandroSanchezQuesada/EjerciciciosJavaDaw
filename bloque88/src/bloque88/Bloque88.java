package bloque88;

import java.util.Scanner;

public class Bloque88 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca numero a buscar");
        int busqueda = sc.nextInt();
        int a[][] = new int[5][5];

        for (int y = 0; y < a.length; y++) {
            for (int x = 0; x < a[y].length; x++) {
                a[y][x] = (int) (Math.random() * 100) + 1;
            }
        }

        for (int y = 0; y < a.length; y++) {
            for (int x = 0; x < a[y].length; x++) {
                System.out.print(a[y][x] + " ");
            }
            System.out.println("");
        }

        System.out.println("");

        System.out.println("Posiciones");
        for (int y = 0; y < a.length; y++) {
            for (int x = 0; x < a[y].length; x++) {
                if (a[y][x] == busqueda) {
                    //System.out.printf("posicion " + a[y][x]);

                    System.out.printf("[%d,%d]: %02d\t", y, x, a[y][x]);
                }

            }
        }

    }

}
