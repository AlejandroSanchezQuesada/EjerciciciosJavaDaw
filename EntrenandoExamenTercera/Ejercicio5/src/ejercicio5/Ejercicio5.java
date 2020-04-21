package ejercicio5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio5 {

    public static void Invierte(String ficheroOrigen, String ficheroCopia) {
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fr = new FileReader(ficheroOrigen);
            br = new BufferedReader(fr);
            fw = new FileWriter(ficheroCopia);
            bw = new BufferedWriter(fw);
            String linea;

            while ((linea = br.readLine()) != null) {

                StringBuilder inverso = new StringBuilder(linea);
                inverso = inverso.reverse();

                bw.write(inverso.toString());
                bw.newLine();

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {

                if (ficheroOrigen != null) {
                    fr.close();

                }
                if (ficheroCopia != null) {
                    bw.close();
                }

            } catch (Exception e) {
            }

        }

    }

    public static void main(String[] args) {

        Invierte("Fichero1.txt", "Fichero2.txt");

    }

}
