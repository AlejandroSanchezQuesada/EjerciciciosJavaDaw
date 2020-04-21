package bloque70;

import java.util.Scanner;

public class Bloque70 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, s, a, b;
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int distancia = 0;
            int distancia2 = 0;
            s = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();

            distancia = Math.abs(s - a);
            distancia2 = Math.abs(a - b);
            int distanciadef = distancia + distancia2;

            System.out.println(distanciadef);

        }

    }

}
