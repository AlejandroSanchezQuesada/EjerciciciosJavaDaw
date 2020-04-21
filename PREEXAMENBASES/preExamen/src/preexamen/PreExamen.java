/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preexamen;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class PreExamen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion=0;
        do{
            System.out.println("Introduzca una opcion");
            System.out.println("JDBC");
            System.out.println("-------------------------");
            System.out.println("1 Coste pedido");
            System.out.println("2 Inserta empleado");
            System.out.println("3 Asignar jefe");
            System.out.println("");
            System.out.println("JPA");
            System.out.println("-------------------------");
            System.out.println("4 Coste pedido");
            System.out.println("5 Inserta empleado");
            System.out.println("6 Asignar jefe");
            System.out.println("========================");
            System.out.println("0 para salir");
            opcion=teclado.nextInt();
            
            switch(opcion) {
                case 1: costePedido(); break;
                case 2: insertaEmpleado(); break;
                case 3: asignaJefe(); break;
                case 4: costePedidoJPA(); break;
                case 5: insertaEmpleadoJPA(); break;
                case 6: asignaJefeJPA(); break;
            }
            
        }while(opcion!=0);
        
        
    }

    private static void costePedido() {
        System.out.println("ejercicio 1");
    }

    private static void insertaEmpleado() {
        System.out.println("ejercicio 2");
    }

    private static void asignaJefe() {
        System.out.println("ejercicio 3");
    }

    private static void costePedidoJPA() {
        System.out.println("ejercicio 4");
    }

    private static void insertaEmpleadoJPA() {
        System.out.println("ejercicio 5");
    }

    private static void asignaJefeJPA() {
        System.out.println("ejercicio 6");
    }

}


