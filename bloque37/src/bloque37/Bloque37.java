package bloque37;

import java.util.Scanner;

public class Bloque37 {

    static int SUMA(int n1, int n2) {
        int resultado = n1 + n2;

        return resultado;
    }

    static int RESTA(int n1, int n2) {
        int resultado = n1 - n2;

        return resultado;

    }

    static int MULTIPLICACION(int n1, int n2) {
        int resultado = n1 * n2;

        return resultado;

    }

    static float DIVISION(int n1, int n2) {
        float resultado = n1 / n2;

        return resultado;

    }

    static void IMPRIMIR_RESULTADOS(int suma, int resta, int multiplicacion, float division) {
        System.out.println(suma);
        System.out.println(resta);
        System.out.println(multiplicacion);
        System.out.println(division);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int NUMERO_01, NUMERO_02, OP_SUMA, OP_RESTA, OP_MULTIPLICACION;
        float OP_DIVISION;
        try {
            System.out.print("Introduzca el primer número: ");
            NUMERO_01 = sc.nextInt();
            System.out.print("Introduzca el segundo número: ");
            NUMERO_02 = sc.nextInt();

            OP_SUMA = SUMA(NUMERO_01, NUMERO_02);
            OP_RESTA = RESTA(NUMERO_01, NUMERO_02);
            OP_MULTIPLICACION = MULTIPLICACION(NUMERO_01, NUMERO_02);
            OP_DIVISION = DIVISION(NUMERO_01, NUMERO_02);

            IMPRIMIR_RESULTADOS(OP_SUMA, OP_RESTA, OP_MULTIPLICACION, OP_DIVISION);
        } catch (ArithmeticException e) {
            System.out.println("HA HABIDO UN ERROR ARITMETICO");
        }catch (Exception e){System.out.println("HA HABIDO OTRO ERROR");}

    }
}
