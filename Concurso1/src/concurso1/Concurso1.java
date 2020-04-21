package concurso1;

import java.util.Scanner;

public class Concurso1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, y, z;

        do {
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            int resultado = 0;
            boolean c = false;
            if (x != 0 || y != 0 || z != 0) {
                 if (y - z != 0 || x != 0) {
                    resultado = (x / (y - z)) - 1;
                }
                if (resultado > 0 || y > x) {
                    
                    System.out.println(resultado);
                } else if (resultado < 0 ) {
                    System.out.println("You must work harder!");
                }


            }

        } while (x != 0 || y != 0 || z != 0);

    }

}
