package examen2;

import java.util.Scanner;

public class Examen2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int npruebas = 0;
        int numeros = 0;
        char letra = 'z';
        try {
            npruebas = sc.nextInt();
        } catch (Exception e) {
            System.out.println("HAS INTRODUCIDO EL NUMERO DE PRUEBAS MAL");
        }

        for (int i = 0; i < npruebas; i++) {
            try {
                numeros = sc.nextInt();
            } catch (Exception e) {
                System.out.println("HAS INTRODUCIDO EL NUMERO DEL DNI MAL");
            }

            try {
                letra = sc.next().charAt(0);
                letra = Character.toUpperCase(letra);

            } catch (Exception e) {
                System.out.println("HAS INTRODUCIDO LA LETRA MAL");
            }

            NIF nuevo = new NIF(numeros, letra);

            if (nuevo.compruebaLetra() == true) {
                System.out.println("OK");
            } else {
                System.out.println(nuevo.letraCorrecta());
            }

        }

    }

}
