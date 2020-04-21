
package bloque12;

import java.util.Scanner;


public class Bloque12 {

    public static void main(String[] args) {
      
    int x,alumnos;
    double notas,sumatorio,media;
    sumatorio = 0;
    Scanner Teclado = new Scanner(System.in);
    
    System.out.println("Cuantos alumnos son?");
    alumnos = Teclado.nextInt();
    
    System.out.println("Introduce las notas de los "+alumnos+" alumnos");
    for(x=1;x<=alumnos;x++){
            System.out.println("Introduzca nota del alumno "+x);
            notas = Teclado.nextDouble();
            sumatorio = sumatorio+notas;
        }
     media = sumatorio/alumnos;
     System.out.println("La media de notas de los alumnos es "+media);
    }
    
}
