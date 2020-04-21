package bloque44;

import java.util.Scanner;

public class Bloque44 {

    static int ordenarray(int a1[]) {
        int orden = 0;
        int anterior = 0;
        int contA = 0;
        int contB = 0;

        System.out.println("El orden del array es ");
        for (int x = 0; x < a1.length; x++) {
            if (a1[x] > a1[anterior]) {
                contA++;
            } else if (a1[x] < a1[anterior]) {
                contB++;
            }
            anterior = x;
            System.out.print(a1[x] + " ");
        }//Fin for
        if (contA == 4) {
            orden = 1;
        } else if (contB == 4) {
            orden = -1;
        } else {
            orden = 0;
        }

        return orden;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a1[] = new int[5];
        try {
            for (int x = 0; x < 5; x++) {
                System.out.println("Introduce el numero del array nº" + x);
                a1[x] = sc.nextInt();
            }//Fin For

            switch (ordenarray(a1)) {
                case 1:
                    System.out.println("y esta ordenado crecientemente");
                    break;
                case -1:
                    System.out.println("y esta ordenado decrecientemente");
                    break;
                default:
                    System.out.println("y no tiene ningun orden");
                    break;
            }

        } catch (Exception e) {

            System.out.println("HA HABIDO UN ERROR");

        }

    }//Fin Main

}
