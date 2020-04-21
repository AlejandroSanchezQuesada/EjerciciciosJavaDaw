package bloque68;

import java.util.Scanner;

public class Bloque68 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String a, b;

        for (int i = 0; i < n; i++) {
            a = sc.next();
            b = sc.next();

            if ("luke".equals(a) && "padre".equals(b)) {
                System.out.println("TOP SECRET");

            } else {
                System.out.println(a + ", yo soy tu " + b);
            }

        }

    }

}
