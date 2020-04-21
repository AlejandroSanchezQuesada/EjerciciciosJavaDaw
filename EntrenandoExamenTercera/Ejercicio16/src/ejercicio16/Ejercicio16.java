package ejercicio16;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio16 {

    public static void mostrarFichero() {
        RandomAccessFile fichero = null;
        try {
            fichero = new RandomAccessFile("nuevo.dat", "rw");
            fichero.seek(0);

            while (true) {
                int n = fichero.readInt();
                System.out.println(n);

            }

        } catch (EOFException ax) {
            System.out.println("Fin fichero");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio16.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio16.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {

        RandomAccessFile fichero = null;

        try {
            fichero = new RandomAccessFile("nuevo.dat", "rw");

            fichero.seek(0);
            fichero.writeInt(69);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio16.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio16.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (Exception e) {
            }

        }
        mostrarFichero();
    }

}
