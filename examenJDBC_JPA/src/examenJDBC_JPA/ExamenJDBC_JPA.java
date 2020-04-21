/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenJDBC_JPA;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class ExamenJDBC_JPA {

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
            System.out.println("1 Inserta usuario");
            System.out.println("2 Mostrar eventos pendientes");
            System.out.println("3 Marcar como completados");
            System.out.println("");
            System.out.println("JPA");
            System.out.println("-------------------------");
            System.out.println("4 Inserta usuario");
            System.out.println("5 Mostrar eventos pendientes");
            System.out.println("6 Marcar como completados");
            System.out.println("========================");
            System.out.println("0 para salir");
            opcion=teclado.nextInt();
            
            switch(opcion) {
                case 1: insertaUsuario(); break;
                case 2: eventosPendientes(); break;
                case 3: completados(); break;
                case 4: insertaUsuarioJPA(); break;
                case 5: eventosPendientesJPA(); break;
                case 6: completadosJPA(); break;
            }
            
        }while(opcion!=0);
        
        
    }

    private static void insertaUsuario() {
        System.out.println("ejercicio 1");
    }

    private static void eventosPendientes() {
        System.out.println("ejercicio 2");
    }

    private static void completados() {
        System.out.println("ejercicio 3");
    }

    private static void insertaUsuarioJPA() {
        System.out.println("ejercicio 4");
    }

    private static void eventosPendientesJPA() {
        System.out.println("ejercicio 5");
    }

    private static void completadosJPA() {
        System.out.println("ejercicio 6");
    }

}


