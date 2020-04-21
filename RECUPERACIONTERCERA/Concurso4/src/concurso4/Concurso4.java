package concurso4;

import java.util.ArrayList;
import java.util.Scanner;

public class Concurso4 {

    public static void main(String[] args) {
        ArrayList<Integer> ListaCeros = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int numeroPruebas = sc.nextInt();

        for (int i = 0; i < numeroPruebas; i++) {

            int numFactorial = sc.nextInt();
            int resultado = 1;
            int cont = 0;
            while (numFactorial != 0) {
                resultado = resultado * numFactorial;
                numFactorial--;
                cont++;
            }
            if (cont < 25) {
                int c1 = cont / 5;
                ListaCeros.add(c1);
            }

            if (cont >= 25 && cont < 125) {
                int c1 = cont / 5;
                int c2 = cont / 25;

                int c3 = c1 + c2;
                ListaCeros.add(c3);
            }
            if (cont >= 125 && cont < 625) {
                int c1 = cont / 5;
                int c2 = cont / 25;
                int c3 = cont / 125;

                int c4 = c1 + c2 + c3;
                ListaCeros.add(c4);

            }

            if (cont >= 625) {
                int c1 = cont / 5;
                int c2 = cont / 25;
                int c3 = cont / 125;
                int c4 = cont / 625;

                int c5 = c1 + c2 + c3 + c4;
                ListaCeros.add(c5);
            }

        }

        for (int i = 0; i < ListaCeros.size(); i++) {
            System.out.println(ListaCeros.get(i));
        }

    }

}
