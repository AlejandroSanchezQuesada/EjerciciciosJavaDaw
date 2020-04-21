package ejercicio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio1 {

    public static void EscribeFicheroNumRandom(String nombre, int lineas) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(nombre);
            bw = new BufferedWriter(fw);

            for (int i = 0; i < lineas; i++) {
                int aleatorio = (int) (Math.random() * 100) + 1;
                bw.write(aleatorio);
                bw.newLine();

            }

        } catch (IOException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (nombre != null) {
                    bw.close();
                }
            } catch (Exception e) {
            }

        }

    }

    public static void main(String[] args) {
        EscribeFicheroNumRandom("fichero.txt", 100);

    }

}
