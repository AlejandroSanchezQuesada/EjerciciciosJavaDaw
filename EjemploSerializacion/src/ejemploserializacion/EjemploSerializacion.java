package ejemploserializacion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjemploSerializacion {
static ArrayList<Coche> listaCoches;
    
    public static void main(String[] args) {
        listaCoches = new ArrayList();
        EscribeCoches();
        LeeCoches();

    }

    private static void LeeCoches() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("coches.dat");
            ois = new ObjectInputStream(fis);

            listaCoches = (ArrayList) ois.readObject();
                    
            for (Coche c: listaCoches) {
                System.out.println(c);
            }
            
            /*Object aux;
            Coche c;

            while (true) {
                aux = ois.readObject();
                if (aux instanceof Coche) {
                    c = (Coche) aux;
                    System.out.println(c.toString());
                }

            }*/

        } catch (EOFException eof) {
            //Cuando salta esta excepcion es que hemos llegado al final del fichero pero no es un error
        } catch (Exception ex) {

        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

    private static void EscribeCoches() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        

        try {
            fos = new FileOutputStream(new File("coches.dat"));
            oos = new ObjectOutputStream(fos);

            Coche c1 = new Coche("Seat", "Alhambra", "2343 CDE", 2015);
            Coche c2 = new Coche("Ford", "Fiesta", "1234 ABC", 2012);
            Coche c3 = new Coche("Renault", "Clio", "9876 ZYXW", 2018);
            Coche c4 = new Coche("Audi", "TT", "1367 ACED", 2017);
            Coche c5 = new Coche("Fiat", "Punto", "1692 POKE", 2008);
            
            listaCoches.add(c1);listaCoches.add(c2);
            listaCoches.add(c3);listaCoches.add(c4);
            listaCoches.add(c5);
            
oos.writeObject(listaCoches);
            //Escribo los objetos en el fichero
          /*  oos.writeObject(c1);
            oos.writeObject(c2);
            oos.writeObject(c3);
            oos.writeObject(c4);
            oos.writeObject(c5);*/

        } catch (IOException ex) {
            Logger.getLogger(EjemploSerializacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(EjemploSerializacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
