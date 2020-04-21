
package bloque19;

import java.util.Scanner;


public class Bloque19 {


    public static void main(String[] args) {
       
        int x,n,sumapares,sumaimpares,numero;
        sumapares = 0;
        sumaimpares = 0;
        Scanner Teclado = new Scanner (System.in);
        
        System.out.println("Cuantos numeros vas a introducir?");
        n = Teclado.nextInt();
        
        for(x=0;x<n;x++){
            System.out.println("Introduce numero");
            numero = Teclado.nextInt();
            
            if(numero%2==0){
                sumapares = sumapares+numero;
            }
            else if(numero%2!=0){
                sumaimpares = sumaimpares+numero;
            }
        }
        System.out.println("La suma de los numeros pares es "+sumapares+" Y la suma de los numeros impares "+sumaimpares);

    }
    
}
