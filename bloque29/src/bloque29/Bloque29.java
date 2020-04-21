
package bloque29;

import java.util.Scanner;

public class Bloque29 {

    static void DibujaTriangulo(int altura){
        for(int x=1;x<=altura;x++){
            for(int y=1;y<=x;y++){
                System.out.print("*");
            }
            System.out.println("");
        }
        
        
    
        
    }
    

    public static void main(String[] args) {
       
        System.out.println("INTRODUCE LA ALTURA TRIANGULO");
        Scanner sc = new Scanner(System.in);
        int altura = sc.nextInt();
        DibujaTriangulo(altura);
        
        
    }
    
}
