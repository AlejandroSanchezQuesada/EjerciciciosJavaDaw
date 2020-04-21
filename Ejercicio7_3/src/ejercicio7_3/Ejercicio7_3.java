package ejercicio7_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio7_3 {

    static void EscribeFicheroTexto(String nombre) {
        Scanner sc = new Scanner(System.in);
        FileWriter documento = null;
        BufferedWriter bw = null;
        String texto = "";

        try {
            documento = new FileWriter(nombre);
            bw = new BufferedWriter(documento);

            do {
                texto = sc.nextLine();

                bw.write(texto);
                bw.newLine();

            } while (!texto.equals(""));

        } catch (Exception e) {
        } finally {
            try {
                if (null != documento) {
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nombrefichero = sc.nextLine();
        System.out.println("El nombre del fichero es " + nombrefichero);
        EscribeFicheroTexto(nombrefichero);

    }

}
