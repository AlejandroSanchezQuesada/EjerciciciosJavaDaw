package bloque20;

import java.util.Scanner;

public class Bloque20 {

    public static void main(String[] args) {
       
        int x,numero;
        Scanner Teclado = new Scanner(System.in);
        
        System.out.println("Introduce numero y te digo si es primo");
        numero = Teclado.nextInt();
        
        if(numero%2==0 || numero%3==0 || numero%5==0 || numero%7==0 || numero%11==0){
            System.out.println("El numero "+numero+" no es primo");
        }
        else {System.out.println("El numero "+numero+" es primo");}
        
        
        
        
    }
    
}
