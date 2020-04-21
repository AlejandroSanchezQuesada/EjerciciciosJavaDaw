package ejercicio7_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio7_1 {

    static void EscribeNumRandom(String _nombre, int _numeroL) {
        int aleatorio = 0;

        FileWriter documento = null;
        BufferedWriter pw = null;

        try {
            documento = new FileWriter(_nombre);
            pw = new BufferedWriter(documento);

            for (int i = 0; i < _numeroL; i++) {
                aleatorio = (int) (Math.random() * 100) + 1;
                String a = String.valueOf(aleatorio);
                pw.write(a);
                pw.newLine();
            }

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        } finally {
            try {
                if (null != documento) {
                    pw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();

            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        int n = sc.nextInt();

        EscribeNumRandom(t, n);

    }

}
