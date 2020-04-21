package ejercicioexamen2;

import java.util.Scanner;

public class Ejercicioexamen2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("     Listado de Planetas      ");
        System.out.println("1- Mercurio");
        System.out.println("2- Venus");
        System.out.println("3- Tierra");
        System.out.println("4- Marte");
        System.out.println("5- Jupiter");
        System.out.println("6- Saturno");
        System.out.println("7- Urano");
        System.out.println("8- Neptuno");
        System.out.println("9- Plutón");

        System.out.println("POR FAVOR INTRODUZCA UNA OPCION PARA VER SU DISTANCIA MEDIA");

        int opcion = sc.nextInt();

        if (opcion == 1) {
            System.out.println("Mercurio esta a 59");
        } else if (opcion == 2) {
            System.out.println("Venus esta a 108");
        } else if (opcion == 3) {
            System.out.println("Tierra esta a 150");
        } else if (opcion == 4) {
            System.out.println("Marte esta a 228");
        } else if (opcion == 5) {
            System.out.println("Jupiter esta a 750");
        } else if (opcion == 6) {
            System.out.println("Saturno esta a 1431");
        } else if (opcion == 7) {
            System.out.println("Urano esta a 2877");
        } else if (opcion == 8) {
            System.out.println("Neptuno esta a 4509");
        } else if (opcion == 9) {
            System.out.println("Plutón esta a 5916");
        } else {
            System.out.println("ERROR 12 NO ESTA ASOCIADO A NINGUN PLANETA");
        }

    }

}
