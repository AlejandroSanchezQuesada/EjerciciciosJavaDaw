package ejercicio7_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio7_5 {

    static String InvierteCadena(String cadena) {

        StringBuilder Grancadena = new StringBuilder();
        Grancadena.append(cadena);
        Grancadena.reverse();

        return "" + Grancadena;

    }

    static String InvierteLineasFichero(String f1) {
        File documento = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = "";
        String cadena = "";

        try {
            documento = new File(f1);
            fr = new FileReader(documento);
            br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {

                cadena = cadena + linea;

            }

        } catch (Exception e) {
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();

            }

        }
        return InvierteCadena(cadena);
    }

    static void CreaFicheroInvertido(String f2, String resultado) {

        FileWriter documento = null;
        BufferedWriter bw = null;

        try {
            documento = new FileWriter(f2);
            bw = new BufferedWriter(documento);

            for (int i = 0; i < resultado.length(); i++) {
                bw.write(resultado.charAt(i));
            }

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

    static void IniciaPrograma(String f1, String f2) {
        String resultado = InvierteLineasFichero(f1);
        CreaFicheroInvertido(f2, resultado);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String f1 = sc.nextLine();
        String f2 = sc.nextLine();

        IniciaPrograma(f1, f2);

    }

}
