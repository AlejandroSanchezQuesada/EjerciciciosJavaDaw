package ejercicio7_18;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio7_18 {

    static Scanner sc = new Scanner(System.in);
    static RandomAccessFile fichero = null;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        fichero = new RandomAccessFile("precios.dat", "rw");
        mostrarPrecios();

        System.out.println("Indica precio incremento");

        double precio = sc.nextDouble();
        int incremento = sc.nextInt();
        modificaPrecios(precio, incremento);
        mostrarPrecios();
    }

    public static void modificaPrecios(double nuevoPrecio, int incremento) {

        try {
            fichero.seek(0);

            double precio;

            while (true) {

                precio = fichero.readDouble();

                if (precio == nuevoPrecio) {
                    fichero.seek(fichero.getFilePointer() - 8);
                    double precioFinal = precio + ((precio * incremento) / 100);
                    fichero.writeDouble(precioFinal);

                }

            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void mostrarPrecios() {

        try {
            fichero.seek(0);
            long id;
            double precio;

            while (true) {
                id = fichero.readLong();
                System.out.println(id);
                precio = fichero.readDouble();
                System.out.println(precio);

            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
