
package bloque13;

import java.util.Scanner;

public class Bloque13 {

    public static void main(String[] args) {
        
    final int Nalumnos = 5;
    int nota,contsobre,contsusp,x;
    double porcapo,porcsusp,aprobados,suspensos;
    Scanner Teclado = new Scanner(System.in);
    
    //Contadores
    contsobre = 0;
    contsusp = 0;
    aprobados = 0;
    suspensos = 0;
    
    System.out.println("Introduzca las notas de los alumnos");
        for(x=1;x<=Nalumnos;x++){
            nota = Teclado.nextInt();
        //Contador de sobresalientes y ceros
            if(nota==10){contsobre++;}
            else if(nota ==0){contsusp++;}
        //Calculador de porcentajes
            if(nota>=5){aprobados++;}
            else{suspensos++;}
        }
        porcapo = (aprobados*100)/(Nalumnos);
        porcsusp = (suspensos*100)/(Nalumnos);
        
        System.out.println("El numero de sobresalientes con 10 es "+contsobre);
        System.out.println("El numero de ceros es "+contsusp);
        System.out.println("El porcentaje de aprobados es "+porcapo+"%");
        System.out.println("El porcentaje de suspensos es "+porcsusp+"%");
        
    }
    
}
