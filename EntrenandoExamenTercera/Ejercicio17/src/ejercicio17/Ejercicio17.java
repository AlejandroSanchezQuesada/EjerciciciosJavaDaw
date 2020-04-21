package ejercicio17;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio17 {

    static RandomAccessFile fichero = null;

    public static void main(String[] args) {

        try {
            fichero = new RandomAccessFile("fichero.tompa", "rw");

            fichero.seek(0);
            for (int i = 0; i < 5; i++) {
                fichero.writeInt(i);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio17.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio17.class.getName()).log(Level.SEVERE, null, ex);
        }
        LeeFichInverso();
    }

    public static void LeeFichInverso() {
        ArrayList<String> Lista = new ArrayList();
        try {
            fichero.seek(0);
            while (true) {
                Lista.add(""+fichero.readInt());

            }

        } catch (EOFException ax) {
            System.out.println("Fin o principio fichero jaja");
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio17.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = Lista.size()-1; i >= 0; i--) {
            System.out.println(Lista.get(i));
        }
        
        

    }

}
