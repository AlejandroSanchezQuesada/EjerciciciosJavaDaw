package bloque17;

import java.util.Scanner;

public class Bloque17 {

    public static void main(String[] args) {
        
    int edad,bebes,ninos,adultos,totalpersonas,caja;
    Scanner Teclado = new Scanner (System.in);
    
    //contadores
    bebes=0;
    ninos=0;
    adultos=0;
    totalpersonas=0;
    
    
    do{
    System.out.println("¿Que edad tienes?");    
    edad = Teclado.nextInt();
       //if(edad==-1)break;
       if(edad<4){
       bebes = bebes+1;
       }
       else if(edad>=4 && edad<=12){
       ninos = ninos+1;
       }
       else if(edad>12){
       adultos = adultos+1;}       
    
    }while(edad!=-1);
    totalpersonas = (bebes+ninos+adultos);   
    caja = (ninos*20)+(adultos*40);
    System.out.println("El total de personas es "+totalpersonas);
    System.out.println("Ha pasado un total de "+bebes+" bebes, "+ninos+" niños y  "+adultos+" adultos");
    System.out.println("El total de la caja es "+caja+"€");
        
    }
    
}
