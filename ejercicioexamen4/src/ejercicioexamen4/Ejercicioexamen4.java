
package ejercicioexamen4;

import java.util.Scanner;

public class Ejercicioexamen4 {


    public static void main(String[] args) {
       
        int dividendo, divisor, resultado,cociente;
        resultado=0;
        cociente=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el dividendo");
        dividendo = sc.nextInt();
        System.out.println("Introduzca divisor");
        divisor = sc.nextInt();
        
        do{
        
        resultado = dividendo-divisor;
        dividendo = resultado;
        cociente++;
        
        }while(resultado-divisor>=0);
      
        System.out.println(cociente);
        
        
    }
    
}
