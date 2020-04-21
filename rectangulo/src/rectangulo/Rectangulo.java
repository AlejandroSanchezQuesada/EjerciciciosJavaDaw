package rectangulo;

import java.util.Scanner;

public class Rectangulo {

   
    public static void main(String[] args) {
        
        int base,altura,i,x;
        Scanner Teclado = new Scanner(System.in);
        
        
        
        do{
            //Declaracion de altura y base
        System.out.println("");
        System.out.println("Introduce la base");
        base = Teclado.nextInt();
        System.out.println("Introduce la altura");
        altura = Teclado.nextInt();
            //Preguntamos si es distinto, si lo es sigue el bucle
            if(base!=0 && altura!=0){
                
                
                for(x=0;x<altura;x++){
                        for(i=0;i<base;i++){
                        System.out.print("*");
                            }
                        System.out.println("");
                    }
                
                
            }
        }while(base!=0 && altura!=0);
        
        
        
        System.out.println("acabo el bucle");
                
        
        
        
        
    }
    
}
