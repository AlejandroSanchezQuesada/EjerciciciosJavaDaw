package ejercicio18;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio18 {

    public static void main(String[] args) {

        RandomAccessFile fichero = null;
        Scanner sc = new Scanner(System.in);
        double precio;
        int porcentaje;
        try {
            fichero = new RandomAccessFile("precios.dat", "rw");
            fichero.seek(0);
            while (true) {
                System.out.println(fichero.readLong());
                System.out.println(fichero.readDouble());

            }

        } catch (EOFException ax) {
            System.out.println("Fin del fichero jaja");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio18.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio18.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            fichero = new RandomAccessFile("precios.dat", "rw");
            fichero.seek(0);
            System.out.println("Introduce Precio");
            precio = sc.nextDouble();
            System.out.println("Introduce Porcentaje");
            porcentaje = sc.nextInt();

            while (true) {

                fichero.readLong();
                long posicion = fichero.getFilePointer();
                double buscando = fichero.readDouble();
                if (precio == buscando) {
                    fichero.seek(posicion);
                    fichero.writeDouble(precio = precio * porcentaje);

                }

            }

        } catch (EOFException ax) {
            System.out.println("Fin fichero jajajaj");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio18.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio18.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
