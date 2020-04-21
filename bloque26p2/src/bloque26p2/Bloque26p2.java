package bloque26p2;

import java.util.Scanner;

public class Bloque26p2 {

    static String cualdia(int x){
    int dia = x;
    String dias = Integer.toString(dia);
    
    
    switch(dias){
        case "1" : dias = "Lunes"; break;
        case "2" : dias = "Martes"; break;
        case "3" : dias = "Miercoles"; break;
        case "4" : dias = "Jueves"; break;
        case "5" : dias = "Viernes"; break;
        case "6" : dias = "Sabado"; break;
        case "7" : dias = "Domingo"; break;
        }
    
   return dias;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un numero del 1 al 7");
        int dia = sc.nextInt();
        
        if(dia<1 && dia>7){
            System.out.println("ERROR DIA INTRODUCIDO NO CORRECTO");}
        else{
        System.out.println("El dia de la semana es "+cualdia(dia));
        }
        
        
    }
    
}
