package adivinanumero;

import java.util.Scanner;

public class Adivinanumero {

    public static void main(String[] args) {
        
    int aleatorio=(int)(Math.random()*10)+1;
    int x,intento;
    Scanner adivinar = new Scanner(System.in);
        for(x=5;x>0;x--){
            System.out.println("Adivina el numero aleatorio del 1 al 10");
            System.out.println("Intentos restantes "+x);
            intento = adivinar.nextInt();
            
            if(intento == aleatorio){
                System.out.println("Enhorabuena el numero adivinado es correcto el "+aleatorio);
                break;
                }
            else if(intento < aleatorio){
                System.out.println("El numero introducido es menor");
            }
            else if(intento > aleatorio){
                System.out.println("El numero introducido es mayor");
            }
        
        
        }

    }
    
}
