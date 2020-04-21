package ejercicio7_7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio7_7 {

    static void SeparaPalabrasFichero(String f1, String f2) {
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

        String Divide[] = cadena.split(" ");

        FileWriter doc2 = null;
        BufferedWriter bw = null;

        try {
            doc2 = new FileWriter(f2);
            bw = new BufferedWriter(doc2);

            for (int i = 0; i < Divide.length; i++) {
                bw.write(Divide[i]);
                bw.newLine();
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

        SeparaPalabrasFichero(f1, f2);

    }

}
