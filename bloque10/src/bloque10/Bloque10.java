package bloque10;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class Bloque10 {
    public static void main(String[] args) {
//Declaracion de variables        
        int n,sumatorio,i,x;
        sumatorio = 0;
        Scanner introducir = new Scanner(System.in);
        System.out.println("Introduzca el valor de N");
        n = introducir.nextInt();
//Comienza el bucle        
        for(i=0;i<n;i++){
        System.out.println("Introduzca un valor a sumar");
            x = introducir.nextInt();
        sumatorio = sumatorio + x;    
        
        }
        System.out.println("El resultado es "+sumatorio);
        
    }
    
}
