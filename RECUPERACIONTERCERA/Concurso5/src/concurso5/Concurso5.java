package concurso5;

import java.util.ArrayList;
import java.util.Scanner;

public class Concurso5 {

    public static void main(String[] args) {

        ArrayList<String> ListaResultados = new ArrayList();
        ArrayList<String> ListaFechas = new ArrayList();
        Scanner sc = new Scanner(System.in);

        int numeroFechas;
        do {
            boolean coincide = false;

            numeroFechas = sc.nextInt();

            if (numeroFechas != 0) {
                for (int i = 0; i < numeroFechas; i++) {

                    String fecha = sc.next();
                    ListaFechas.add(fecha);
                }

                for (int i = 0; i < ListaFechas.size(); i++) {
                    for (int j = 0; j < ListaFechas.size(); j++) {
                        if (!ListaFechas.get(i).equals(ListaFechas.get(j))) {
                            String dividePrimero[] = ListaFechas.get(i).split("/");
                            String divideSegundo[] = ListaFechas.get(j).split("/");

                            if (dividePrimero[0].equals(divideSegundo[0]) && dividePrimero[1].equals(divideSegundo[1])) {
                                coincide = true;
                                j = 999;
                                i = 999;
                            }

                        }

                    }
                }
                if (coincide == true) {
                    ListaResultados.add("SI");
                } else {
                    ListaResultados.add("NO");
                }
                ListaFechas.removeAll(ListaFechas);
            }

        } while (numeroFechas != 0);

        for (int i = 0; i < ListaResultados.size(); i++) {
            System.out.println(ListaResultados.get(i));
        }

    }

}
