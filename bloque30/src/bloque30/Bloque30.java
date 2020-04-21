package bloque30;

import java.util.Scanner;

public class Bloque30 {

    static String Signo(int n) {
        String resultado;
        if (n > 0) {
            resultado = "El Signo es positivo";
        } else if (n < 0) {
            resultado = "El Signo es negativo";
        } else {
            resultado = "El Signo es neutro";
        }

        return resultado;
    }

    public static void main(String[] args) {
        int n;
        do {
            System.out.println("INTRODUCE NUMERO Y TE DIGO SI ES POSITIVO,NEGATIVO,NEUTRO");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            System.out.println(Signo(n));

        } while (n != 999);

    }

}
