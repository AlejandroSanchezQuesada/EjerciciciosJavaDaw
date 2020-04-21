package ejercicio3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio3 {

    static Scanner sc = new Scanner(System.in);

    public static void EscribeFicheroTexto(String nombre) {
        String linea = "ABCFDZ";
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(nombre);
            bw = new BufferedWriter(fw);
            while (!linea.equals("")) {
                System.out.println("Inserta Linea");
                linea = sc.nextLine();

                bw.write(linea);
                bw.newLine();
            }

        } catch (IOException ex) {
            Logger.getLogger(Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (null != nombre) {
                    bw.close();
                }
            } catch (Exception e) {
            }

        }

    }

    public static void main(String[] args) {

        EscribeFicheroTexto("fichero.txt");

    }

}
