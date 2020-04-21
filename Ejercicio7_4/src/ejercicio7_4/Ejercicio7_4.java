package ejercicio7_4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class Ejercicio7_4 {

    static void CopiaFicheroTexto(String f1, String f2) throws IOException {

        FileChannel entrada = null;
        FileChannel salida = null;

        try {
            entrada = new FileInputStream(f1).getChannel();
            salida = new FileOutputStream(f2).getChannel();
            salida.transferFrom(entrada, 0, entrada.size());

        } catch (Exception e ) {
            System.out.println("No existe el archivo");
        } finally {
            entrada.close();
            salida.close();

        }

    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String f1 = sc.nextLine();
        String f2 = sc.nextLine();

        CopiaFicheroTexto(f1, f2);

    }

}
