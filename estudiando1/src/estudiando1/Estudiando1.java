package estudiando1;

import java.util.Scanner;

public class Estudiando1 {

    static void impares(int n1, int n2) {

        if (n1 > n2) {
            for (int x = n2; x < n1; x++) {
                if (x % 2 != 0) {
                    System.out.print(x + " ");
                }//fin if

            }//fin for

        }//fin if
        else {
            for (int y = n1; y < n2; y++) {
                if (y % 2 != 0) {
                    System.out.println(y + " ");

                }

            }

        }

    }// fin impares

    public static void main(String[] args) {

        int n1, n2;
        Scanner sc = new Scanner(System.in);
        boolean error;
        do{
        try {
            System.out.println("Introduce los numericos");
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            error=false;

            impares(n1, n2);

        } catch (Exception e) {
            
            System.out.println("HAS TENIDO UN ERROR");
            sc.nextLine();
            error=true;
        }}while(error);

    }

}
