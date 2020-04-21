package bloque86;

import java.util.Scanner;

public class Bloque86 {

    static void codificaCesar(String cadena, String abc) {
        StringBuilder cad = new StringBuilder(cadena);
        for (int i = 0; i < cadena.length(); i++) {
            boolean comprueba = false;
            for (int j = 0; j < abc.length() && comprueba == false; j++) {
                if (cadena.charAt(i) == abc.charAt(j)) {
                    cad.setCharAt(i, abc.charAt((j + 5)%cadena.length()));
                    comprueba = true;

                }//fin if

            }//fin for anidado
        }//fin for

        System.out.println("Cadena codificada");
        System.out.println(cad);
        
    }//fin funcion
    
 
    
    
    
    
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String abc = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789 ";

        System.out.println("Introduce la cadena");
        String cadena = sc.nextLine();
        System.out.println("Palabra sin codificar");
        System.out.println(cadena);

        codificaCesar(cadena, abc);
        System.out.println("");
    }

}
