package ejercicioexamen3;

import java.util.Scanner;

public class Ejercicioexamen3 {

    public static void main(String[] args) {

        int primero, segundo;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca primer numero");
        primero = sc.nextInt();
        System.out.println("Introduzca segundo numero");
        segundo = sc.nextInt();
        System.out.println("Los multiplos entre " + primero + " y " + segundo + " son: ");
        for (int x = primero; x < segundo; x++) {
            if (x % 4 == 0) {
                System.out.print(x + " ");
            }

        }

    }

}
