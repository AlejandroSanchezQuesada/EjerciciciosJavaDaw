package acepta2reto2;

import java.util.Scanner;

public class Acepta2reto2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base;
        int resultado = 0;
        String tresultado = "";
        String buscar = "";
        int aux = 0;

        base = sc.nextInt();
        buscar = sc.next();
      
        
        for (int i = 0; i < 50; i++) {
            resultado = (int) Math.pow(base, i);
            tresultado = Integer.toString(resultado);
            
            
            
            
            
        }
        
        
        
        
        
        
     
    }

}
