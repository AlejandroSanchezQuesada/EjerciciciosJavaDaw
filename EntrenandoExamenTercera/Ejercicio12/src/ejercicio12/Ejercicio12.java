package ejercicio12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio12 {

    public static void EscribeFich(String fichero) {
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fos = new FileOutputStream(fichero);
            dos = new DataOutputStream(fos);

            for (int i = 1; i <= 100; i++) {
                int numero = (int) (Math.random() * 100) + 1;

                dos.writeInt(numero);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio12.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void LeeFich(String fichero){
    FileInputStream fis = null;
    DataInputStream dis = null;
    
        try {
            fis = new FileInputStream(fichero);
            dis = new DataInputStream(fis);
            
            for (int i =1; i <= 100; i++) {
                System.out.println(dis.readInt());
            }
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio12.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   

public static void main(String[] args) {
        
        EscribeFich("Fichero.bin");
        LeeFich("Fichero.bin");
        
        
        
    }
    
}
