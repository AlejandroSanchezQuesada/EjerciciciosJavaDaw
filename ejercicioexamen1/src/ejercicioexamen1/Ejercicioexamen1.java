package ejercicioexamen1;

import java.util.Scanner;

public class Ejercicioexamen1 {

    public static void main(String[] args) {
        int segundos, minutos, horas;
        Scanner sc = new Scanner(System.in);

        minutos = 0;
        horas = 0;
        System.out.println("Introduzca un numero en segundos");

        segundos = sc.nextInt();

        if (segundos >= 60) {

            while (segundos >= 60) {
                minutos++;
                segundos = segundos - 60;
            }
            while (minutos >= 60) {
                horas++;
                minutos = minutos - 60;
            }
        }
        System.out.println("Resultado horas " + horas + " minutos " + minutos + " segundos " + segundos + "");

    }

}
