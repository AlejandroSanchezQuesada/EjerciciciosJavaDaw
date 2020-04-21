package bloque45;

import java.util.Scanner;

public class Bloque45 {

    static void insertaElemento(int a1[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("");//Espacio en Blanco
        System.out.println("Inserte el Numero que quieres ver");
        int numero = sc.nextInt();
        System.out.println("Inserte la posicion en la que quieres que vaya");
        int posicion = sc.nextInt();
        int tamano = a1.length;

        for (int i = tamano-2; i >= posicion; i--) {
            a1[i+1] = a1[i];
        }
       a1[posicion] = numero;
        //Escribir nuevo Array
        System.out.println("");
        for (int x = 0; x < a1.length; x++) {
            System.out.print(a1[x] + " ");
        }

    }//Fin Void insertaElemento

    public static void main(String[] args) {

        int a1[] = new int[10];
        for (int x = 0; x < a1.length; x++) {
            a1[x] = x;

            System.out.print(a1[x] + " ");
        }//Fin For

        try {
            insertaElemento(a1);

        } catch (Exception e) {
            System.out.println("ERROR");
        }

    }//Fin Main

}
