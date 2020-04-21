package estudiando.pkg3;

import java.util.Scanner;

public class Estudiando3 {

    static void primosanteriores(int n) {

        for (int x = 1; n>=x; n--) {
            if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0) {

            }
            else{
            System.out.println(n);}

        }

    }

    static void primos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numerico");
        int n = sc.nextInt();

        primosanteriores(n);

    }

    public static void main(String[] args) {
        try {
            primos();
        } catch (Exception e) {
            System.out.println("TOMA ERROR!");

        }

    }

}
