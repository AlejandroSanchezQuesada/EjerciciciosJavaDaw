package bloque6ejer2;

import java.util.Calendar;

/*
Programa que lee la hora con formato hora, minutos y segundos e indica la hora, 
minutos y segundos después de que haya transcurrido un segundo.
Por ejemplo: si se introduce: 23:59:59   --->  0:0:0
*/
public class Bloque6ejer2 {

    public static void main(String[] args) {
//Declaracion variables
    int hora,minutos,segundos,segundoplus;
//Creamos el Calendar y a continuacion le damos valor a las variables                        
        Calendar fecha = Calendar.getInstance();
        hora = fecha.get(Calendar.HOUR_OF_DAY);
        minutos = fecha.get(Calendar.MINUTE);
        segundos = fecha.get(Calendar.SECOND);
        segundoplus = segundos+1;
//Mostramos la hora actual
        System.out.println("Hora Actual");
        System.out.println(hora+":"+minutos+":"+segundos);
//Mostramos la hora + 1 segundo        
        System.out.println("Hora con un segundo mas");
        System.out.println(hora+":"+minutos+":"+segundoplus);

    }
    
}
