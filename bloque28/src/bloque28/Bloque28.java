package bloque28;

import java.util.Scanner;

public class Bloque28 {

    static void TablaMultiplicar(int numero) {
        int x, resultado;
        for (x = 1; x <= 10; x++) {
            resultado = numero * x;
            System.out.println(x + " x " + numero + " = " + resultado);
        }
    }

    static void ImprimeSerie(int numero1, int numero2) {
        if (numero1 > numero2) {
            for (int x = numero1; x >= numero2; x--) {
                System.out.print(x + " ");
            }
        }
        else{
            for (int x = numero2; x >= numero1; x--) {
                System.out.print(x + " ");
            }
        }

    }

    public static void main(String[] args) {

        System.out.println("**********************");
        System.out.println("*        MENU        *");
        System.out.println("**********************");
        System.out.println("1. Tabla de Multiplicar");
        System.out.println("2. Imprime Serie");
        System.out.println("3. Salir");
        System.out.println(" ");

        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione una opcion");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Que numero quieres la tabla");
                int numero = sc.nextInt();
                TablaMultiplicar(numero);
                break;
            case 2:
                System.out.println("Introduce los dos numeros que quieras ver la serie");
                int numero1 = sc.nextInt();
                int numero2 = sc.nextInt();
                ImprimeSerie(numero1, numero2);
                break;
            case 3:
                System.out.println("SALIENDO DEL PROGRAMA"); break;

        }

    }

}
