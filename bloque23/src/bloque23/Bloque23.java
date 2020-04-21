package bloque23;

import java.util.Scanner;


public class Bloque23 {

    public static void main(String[] args) {
        
        int divisor,numero,contador;
        Scanner Teclado = new Scanner (System.in);
        System.out.println("Introduzca el numero y sacaremos sus divisores");
        numero = Teclado.nextInt();
        
        for(divisor=1;divisor<=numero;divisor++){
            if(numero%divisor==0){
                System.out.println("Un divisor de "+numero+" es el "+divisor);
            }
            
            
        
        }
        
        
    }
    
}
