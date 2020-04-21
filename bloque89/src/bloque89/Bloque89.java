package bloque89;

import java.util.Scanner;

public class Bloque89 {
    
    static void desplazaCircular(String cadena){
    
    char priult = cadena.charAt(0);
        for (int i = 1; i < cadena.length(); i++) {
            System.out.print(cadena.charAt(i));
        }
        System.out.print(priult);
    
    
    
    
    
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte cadena");
        String cadena = sc.nextLine();
        
        System.out.println(cadena);
        System.out.println("");
        desplazaCircular(cadena);
        
        
    }
    
}
