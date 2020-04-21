package concurso2;

import java.util.Scanner;

public class Concurso2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numero;
        String leeresultados = "";
        do {
            numero = sc.nextInt();

            // double elevao = Math.pow(numero, 10);
            if (numero > -1) {
                // if (numero == 0 || numero > -1 && numero < elevao) {

                if (numero == 0) {
                    leeresultados = leeresultados + "1";
                } else {

                    String aPares = numero + "";
                    int cont = 0;

                    for (int i = 0; i < aPares.length(); i++) {
                        int comprueba = Integer.parseInt("" + aPares.charAt(i));
                        if (comprueba % 2 == 0) {
                            cont++;
                        }

                    }
                    if (cont == aPares.length()) {
                        leeresultados = leeresultados + "1";
                    } else {
                        leeresultados = leeresultados + "0";
                    }
                }
                // }

            }

        } while (numero > -1);

        for (int i = 0; i < leeresultados.length(); i++) {
            if (leeresultados.charAt(i) == '1') {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

    }

}
