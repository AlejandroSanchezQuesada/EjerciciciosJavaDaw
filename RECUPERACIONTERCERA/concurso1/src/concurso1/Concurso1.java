package concurso1;

import java.util.ArrayList;
import java.util.Scanner;

public class Concurso1 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int numero;
        ArrayList<String> ListaNumeros = new ArrayList();
        do {
            numero = sc.nextInt();
            
            if (numero > -1) {
                String numeroDivido = "" + numero;
                int sumatorio = 0;
                String cadena = "";
                for (int i = 0; i < numeroDivido.length(); i++) {
                    if (i == numeroDivido.length() - 1) {
                        cadena = cadena + (numeroDivido.charAt(i) + " = ");
                    } else {
                        cadena = cadena + (numeroDivido.charAt(i) + " + ");
                        
                    }
                    
                    sumatorio = sumatorio + Integer.parseInt("" + numeroDivido.charAt(i));
                    
                }
                cadena = cadena + (sumatorio);
                ListaNumeros.add(cadena);
            }
            
        } while (numero > -1);
        
        for (int i = 0; i < ListaNumeros.size(); i++) {
            System.out.println(ListaNumeros.get(i));
        }
        
    }
    
}
