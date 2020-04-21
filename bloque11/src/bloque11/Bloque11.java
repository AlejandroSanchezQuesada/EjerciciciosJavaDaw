package bloque11;

import java.util.Scanner;

public class Bloque11 {
    public static void main(String[] args) {
        int n;
        Scanner teclado = new Scanner(System.in);
        do{
        System.out.println("*******************************");
        System.out.println("MENU SENCILLO POR ALEJANDR SANCHEZ");
        System.out.println("*******************************");
        System.out.println("SELECCIONA LA OPCION POR FAVOR");
        
        System.out.println("1 - Saludar");
        System.out.println("2 - Despedirse");
        System.out.println("3 - Salir");
        
        n = teclado.nextInt();
        
        if(n==1){System.out.println("Hola Pepito");}
        else if(n==2){System.out.println("Adios");}
        
        }while(n!=3);
        
        
        
        
        
    }
    
}
