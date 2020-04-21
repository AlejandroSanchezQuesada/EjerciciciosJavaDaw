package bloque39;

import java.util.Scanner;

public class Bloque39 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int arrayone[] = new int[5];
        for (int x = 0; x < 5; x++) {
            System.out.println("Introduce Numero");
            
            arrayone[x] = sc.nextInt();
        }
        for (int n1 = 0; n1 <= 4; n1++) {
            System.out.print(arrayone[n1]+" ");

        }
        System.out.println(" ");
        //PETA AQUI ABAJO
        for (int n2 = 4; n2 >= 0; n2--) {
            System.out.print(arrayone[n2]+" ");
        } 

    }

}
