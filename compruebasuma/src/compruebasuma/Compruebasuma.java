package compruebasuma;

import java.util.Scanner;

/*
Programa que lee tres números y comprueba si alguno de ellos es suma de los otros dos.
Si se cumple esta condición escribir ‘Iguales’ y en caso contrario ‘Distintos’
*/
public class Compruebasuma {

    public static void main(String[] args) {
      
        int n1,n2,n3;
        String resultado;
        Scanner Teclado= new Scanner(System.in);
// Introducimos el valor de los numeros
        System.out.println("Introduce el primer numero");
        n1 = Teclado.nextInt();
        System.out.println("Introduce el segundo numero");
        n2 = Teclado.nextInt();
        System.out.println("Introduce el tercer numero");
        n3 = Teclado.nextInt();     
//Comprobacion de sumas
        if(n1==n2+n3){
            resultado = "Son iguales";
        }
        else if(n2==n1+n3){
            resultado = "Son iguales";
        }
        else if(n3==n1+n2){
            resultado = "Son iguales";
        }
        else{
            resultado = "Son distintos";
        }
//Decimos resultado        
        System.out.print(resultado);
        
    }
    
}
