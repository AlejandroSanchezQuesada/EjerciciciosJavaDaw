package bloque72;

import java.util.Scanner;

public class Bloque72 {

    static void cambiafila(int a[][], int fila1, int fila2) {
        int aux[] = new int[10];
        for (int x = 0; x < 10; x++) {
            aux[x] = a[fila1][x];
            a[fila1][x] = a[fila2][x];
            a[fila2][x] = aux[x];
        }

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.print(a[x][y] + " ");
            }
            System.out.println(" ");
        }

    }

    public static void main(String[] args) {
        int fila1, fila2;
        Scanner sc = new Scanner(System.in);
        int a[][] = new int[10][10];

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                a[x][y] = (int) (Math.random() * 10) + 1;
            }
        }

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.print(a[x][y] + " ");
            }
            System.out.println(" ");
        }

        try {
            System.out.println("Inserte fila que quiere cambiar");
            fila1 = sc.nextInt();
            System.out.println("Inserte posicion nueva de la fila que quiere cambiar");
            fila2 = sc.nextInt();

            cambiafila(a, fila1, fila2);

        } catch (Exception e) {
        }

    }

}
