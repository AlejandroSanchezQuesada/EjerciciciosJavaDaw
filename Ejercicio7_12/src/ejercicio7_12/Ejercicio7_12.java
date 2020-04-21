package ejercicio7_12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio7_12 {

    public static void EscribeFichero1_100(String nombrefich) throws FileNotFoundException {

        FileOutputStream fos = new FileOutputStream(nombrefich);

        DataOutputStream dos = new DataOutputStream(fos);

        try {

            for (int i = 1; i <= 100; i++) {
                dos.writeInt(i);

            }

        } catch (IOException e) {
            System.out.println("Error E/S");
        } finally {
            try {
                if (null != fos) {
                    dos.close();
                }
            } catch (Exception e) {
            }
        }

    }

    public static void LeeFicheroInt100(String nombrefich) throws FileNotFoundException {

        FileInputStream fis = new FileInputStream(nombrefich);
        DataInputStream dis = new DataInputStream(fis);

        try {

            for (int i = 1; i <= 100; i++) {
                System.out.print(dis.readInt());
                if (i != 100) {
                    System.out.print(", ");
                }

            }

        } catch (IOException e) {
            System.out.println("Error E/S");
        } finally {
            try {
                if (null != fis) {
                    dis.close();
                }
            } catch (Exception e) {
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        String nombrefich = "fichero.bin";
        EscribeFichero1_100(nombrefich);

        LeeFicheroInt100(nombrefich);

    }

}
