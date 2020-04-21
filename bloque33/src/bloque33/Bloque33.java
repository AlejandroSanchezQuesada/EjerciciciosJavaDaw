package bloque33;

import java.util.Scanner;

public class Bloque33 {

    static int mayor(int n1, int n2, int n3) {
        int mayor;

        if (n1 > n2 && n1 > n3) {
            mayor = n1;
        } else if (n2 > n1 && n2 > n3) {
            mayor = n2;
        } else {
            mayor = n3;
        }

        return mayor;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca 3 numeros");
        System.out.println("introduzca numero 1");
        int n1 = teclado.nextInt();
        System.out.println("Introduzca numero 2");
        int n2 = teclado.nextInt();
        System.out.println("Introduzca numero 3");
        int n3 = teclado.nextInt();

        System.out.println("El mayor es " + mayor(n1, n2, n3));

    }

}
