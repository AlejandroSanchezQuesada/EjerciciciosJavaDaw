package ejercicio7_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ejercicio7_2 {

    static int SumaFicheroEnteros() {
        File documento = null;
        FileReader fr = null;
        BufferedReader br = null;
        int suma = 0;

        try {
            documento = new File("documento.txt");
            fr = new FileReader(documento);
            br = new BufferedReader(fr);
            String linea = "";

            while ((linea = br.readLine()) != null) {

                suma = suma + Integer.parseInt(linea);

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
        return suma;
    }

    public static void main(String[] args) {

        System.out.println(SumaFicheroEnteros());

    }

}
