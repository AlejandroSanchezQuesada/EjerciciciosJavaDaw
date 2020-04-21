package bloque69;

import java.util.Scanner;

public class Bloque69 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, midiclorianos, cont;

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            midiclorianos = sc.nextInt();
            String resultado = Integer.toString(midiclorianos, 5);
            cont = 0;
            for (int j = 0; j < resultado.length(); j++) {
                if (resultado.charAt(j) == '4') {
                    cont++;
                }
            }

            if (cont > 1) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }

        }

    }

}
