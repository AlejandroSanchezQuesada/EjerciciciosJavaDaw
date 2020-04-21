package bloque34;

import java.util.Scanner;

public class Bloque34 {

   static void tablamultiplicar(int n){
       System.out.println("TABLA DEL"+n);
    for(int x=1;x<=10;x++){
        int resultado = x*n;
        System.out.println(n+" * "+x+" = "+resultado);
    
    }
    
    }
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;

        System.out.println("TABLAS MULTIPLICAR");
        System.out.println("Introduzca un numero comprendido del 1 al 10");

        numero = sc.nextInt();

        if(numero<1 || numero>10){
            System.out.println("ERROR EL NUMERO ESTÁ FUERA DE RANGO");
        }
        else{
            tablamultiplicar(numero);
        
        }

    }

}
