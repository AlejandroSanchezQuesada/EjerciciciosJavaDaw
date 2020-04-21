package bloque31;

import java.util.Scanner;

public class Bloque31 {

    static void impares(int numeroprimero, int numerosegundo) {
        if (numeroprimero > numerosegundo) {
            for (int x = numeroprimero; x >= numerosegundo; x--) {
                if (x % 2 != 0) {
                    System.out.print(x + " ");
                }

            }
        } else {
            for (int x = numeroprimero; x <= numerosegundo; x++) {
                if (x % 2 != 0) {
                    System.out.print(x + " ");
                }
            }

        }

    }

    public static void main(String[] args) {

        int n1, n2;

        System.out.println("INTRODUZCA DOS NUMEROS Y MOSTRAREMOS LOS IMPARES ENTRE ELLOS");
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca numero1");
        n1 = sc.nextInt();
        System.out.println("Introduzca numero2");
        n2 = sc.nextInt();

        impares(n1, n2);

    }

}
