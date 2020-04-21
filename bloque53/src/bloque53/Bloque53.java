package bloque53;

import java.util.Scanner;

public class Bloque53 {

    static int buscarSiguiente(int numero, int posicion, int a[]) {
        int resultado = 0;

        if (a[posicion] == numero) {
            resultado = posicion;
        }// fin if
        else {
            resultado = -1;
        }// fin else

        return resultado;

    }// fin buscasiguiente

    public static void main(String[] args) {
        int numero, posicion;
        Scanner sc = new Scanner(System.in);
        int a[] = new int[20];

        for (int i = 0; i < a.length; i++) {

            a[i] = (int) (Math.random() * 10) + 1;

        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");// Espacio en blanco
        
        
        try {
            System.out.println("Introduce el numero a buscar");
        numero = sc.nextInt();
        System.out.println("Introduce la posicion a partir de la que buscar");
        posicion = sc.nextInt();

        for (int i = posicion; i < a.length; i++) {

            if (buscarSiguiente(numero, posicion, a) == -1) {
            } else {
                System.out.println("Posicion: " + buscarSiguiente(numero, posicion, a));
            }
            posicion++;

        }
        } catch (Exception e) {
            
            System.out.println("HAY UN ERROR");
        }
        

    }

}
