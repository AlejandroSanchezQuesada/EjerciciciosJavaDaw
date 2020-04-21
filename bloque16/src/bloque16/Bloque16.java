
package bloque16;

import java.util.Scanner;


public class Bloque16 {
    public static void main(String[] args) {
        
        int numero,x,calculafac;
        calculafac = 1;
        Scanner Teclado = new Scanner (System.in);
        
        System.out.println("Introduce el numero que quieres sacar factorial");
        numero = Teclado.nextInt();

        for(x=1;x<=numero;numero--){
            calculafac = calculafac * numero;

        }
        System.out.println(calculafac);
    }
    
}
