package bloque27p1;

import java.util.Scanner;

public class Bloque27p1 {
    
    static int potencia(int base, int exponente){
        int resultado = 1;
        for(int x =0;x<exponente;x++){
        
         resultado = resultado * base;   
            
        };
    
    return resultado;}
    

    public static void main(String[] args) {
       
        int base,exponente;
        Scanner pedir = new Scanner(System.in);
        
        do{
            System.out.println("Introduzca BASE");
            base = pedir.nextInt();
            System.out.println("Introduzca EXPONENTE");
            exponente = pedir.nextInt();
            System.out.println("la potencia de "+base+" y "+exponente+" es "+potencia(base,exponente));
        }while(base!=0 && exponente!=0);

    }
   
}
