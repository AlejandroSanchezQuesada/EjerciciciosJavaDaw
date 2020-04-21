package ejercicio6_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio6_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Password> contrasenas;
        
        contrasenas = new ArrayList();
        System.out.println("Introduzca el numero de contraseñas que quieres poner");
        int npasswords = sc.nextInt();
        for (int i = 0; i < npasswords; i++) {
            int longitud = sc.nextInt();
            contrasenas.add(new Password(longitud));
        }
        
        for (int i = 0; i < contrasenas.size(); i++) {
            System.out.println("La contraseña nº"+i+" = "+contrasenas.get(i).getContrasena()+" ");
            if (contrasenas.get(i).EsFuerte() == true) {
                System.out.print("Es Fuerte");
                System.out.println("");
            }else{System.out.print("Es Debil");
                System.out.println("");}
        }
        
        
    }

}
