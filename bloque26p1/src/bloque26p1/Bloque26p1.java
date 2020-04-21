
package bloque26p1;

import java.util.Scanner;


public class Bloque26p1 {
    static boolean esbisiesto(int x){
    return  ((x%4 ==0) && (x%100 !=0)) || (x%400==0);
    }

    public static void main(String[] args) {
        System.out.println("Introduce un año comprendido entre 1900 y 2100");
        Scanner sc = new Scanner(System.in);
        int anyo = sc.nextInt();
            if(anyo<1900 && anyo<2100){
                System.out.println("ERROR AÑO INTRODUCIDO NO VALIDO");
            }
            else{
                if(esbisiesto(anyo)==true){
                    System.out.println("El año "+anyo+" es bisiesto");
                }
                else if(esbisiesto(anyo)==false){
                    System.out.println("El año "+anyo+" NO es bisiesto");
                }
            }
    }

        
        
        
    }

