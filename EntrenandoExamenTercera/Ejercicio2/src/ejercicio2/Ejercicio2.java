package ejercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio2 {

    public static void SumaFicherosEnteros(String nombre) {
        FileReader fr = null;
        BufferedReader br = null;
        int suma = 0;
        try {
            fr = new FileReader(nombre);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {

                int sumatorio = Integer.parseInt(linea);
                suma = suma + sumatorio;

            }
            System.out.println(suma);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (fr != null) {
                    fr.close();
                }

            } catch (Exception e) {
            }

        }

    }

    public static void main(String[] args) {

        SumaFicherosEnteros("fichero.txt");

    }

}
