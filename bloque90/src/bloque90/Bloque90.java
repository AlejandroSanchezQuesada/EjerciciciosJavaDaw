package bloque90;

import java.util.Scanner;

public class Bloque90 {

    static void codifica(String clave, String cadena, String abecedario) {
        StringBuilder cad = new StringBuilder(cadena);

        for (int i = 0; i < cadena.length(); i++) {
            boolean comprueba = false;
            for (int j = 0; j < abecedario.length(); j++) {
                if (cad.charAt(i) == abecedario.charAt(j) && comprueba == false) {
                    cad.setCharAt(i, clave.charAt(j));
                    comprueba = true;
                }

            }
        }

        System.out.println(cad);

    }

    static void decodifica(String clave, String cadena, String abecedario) {
        StringBuilder cad = new StringBuilder(cadena);

        for (int i = 0; i < cadena.length(); i++) {
            boolean comprueba = false;
            for (int j = 0; j < clave.length() && comprueba == false; j++) {
                if (cad.charAt(i) == clave.charAt(j)) {
                    cad.setCharAt(i, abecedario.charAt(j));
                    comprueba = true;
                }
            }
        }
        System.out.println(cad);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String clave = "qwertyuiopasdfghjklzxcvbnm";
        String abecedario = "abcdefghijklmnopqrstuvwxyz";

        System.out.println("Inserte cadena");
        String cadena = sc.nextLine();

        codifica(clave, cadena, abecedario);
        System.out.println("");
        decodifica(clave, cadena, abecedario);

    }

}
