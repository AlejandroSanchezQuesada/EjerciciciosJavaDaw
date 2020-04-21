package ejercicio7_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio7_6 {

    static void InvierteCadena(String f1, String f2) {

        File documento = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = "";
        String cadena = "";
        String resultado = "";
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

        String Divide[] = cadena.split(" ");

        for (int i = Divide.length - 1; i >= 0; i--) {
            resultado = resultado + Divide[i] + " ";
        }

        FileWriter doc2 = null;
        BufferedWriter bw = null;

        try {
            doc2 = new FileWriter(f2);
            bw = new BufferedWriter(doc2);

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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String f1 = sc.nextLine();
        String f2 = sc.nextLine();
        InvierteCadena(f1, f2);

    }

}
