package bloque7ejer1;

import java.util.Scanner;

public class Bloque7ejer1 {
    
    public static void main(String[] args) {
//Declaramos variables        
     int stock;
     int pedido;
     Scanner Teclado = new Scanner(System.in);
//Comienza programa

        for(stock=1000;stock>=200;stock=stock-pedido){
//Introducimos pedido
            System.out.println("Introduzca el pedido, Stock actual "+stock);
            pedido = Teclado.nextInt();
        }
//Mensaje de alerta
        System.out.println("------------------------------------------");
        System.out.println("CUIDADO EL STOCK ESTA POR DEBAJO DE 200");
        System.out.println("------------------------------------------");
    }
}
