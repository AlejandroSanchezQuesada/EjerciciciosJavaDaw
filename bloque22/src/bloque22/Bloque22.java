package bloque22;

import java.util.Scanner;

public class Bloque22 {

    public static void main(String[] args) {
        Scanner Teclado = new Scanner(System.in);
        int base,exponente,resultado,x;
        System.out.println("Introduzca la base");
        base = Teclado.nextInt();
        System.out.println("Introduzca el exponente");
        exponente = Teclado.nextInt();
        
        resultado = 1;
        for(x=0;x<exponente;x++){
                resultado = resultado * base;
        
            }
        
        System.out.println(resultado);
        
    }
    
}
