package bloque77;

import java.util.Scanner;

public class Bloque77 {

    static String calculadni(int dni) {

        String letra;

        char a[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resultado = dni % 23;
        letra = dni + "" + a[resultado];

        return letra;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int dni = sc.nextInt();

            System.out.println(calculadni(dni));

        } catch (Exception e) {
            System.out.println("ERROR EN DNI, HAS PUESTO UNA LETRA");
        }

    }

}
