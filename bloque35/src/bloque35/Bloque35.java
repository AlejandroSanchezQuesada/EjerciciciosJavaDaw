package bloque35;

import java.util.Scanner;

public class Bloque35 {

    static int cuentacifras(int numero) {
        int ncifras = 0;
        do {
            numero = numero / 10;
            Math.floor(numero);
            ncifras++;

        } while (numero > 0);

        return ncifras;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("CONTADOR DE CIFRAS INTRODUZCA EL NUMERO");
        System.out.println("Introduzca numero");
        try {
            int numero = sc.nextInt();

            System.out.println("El numero de cifras es " + cuentacifras(numero));
        } catch (Exception e) {
            System.out.println("ERROR NO HA SIDO UN NUMERITO");
        }
    }

}
