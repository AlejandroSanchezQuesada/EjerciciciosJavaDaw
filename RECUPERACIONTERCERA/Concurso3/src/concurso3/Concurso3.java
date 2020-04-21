package concurso3;

import java.util.ArrayList;
import java.util.Scanner;

public class Concurso3 {

    public static void main(String[] args) {
        ArrayList<String> ListaPalabras = new ArrayList();
        ArrayList<String> ListaResultados = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int numeroPruebas = sc.nextInt();
        String vocales = "aeiou";
        int a, e, i, o, u;
        for (int x = 0; x <= numeroPruebas; x++) {
            String palabra = sc.nextLine();
            ListaPalabras.add(palabra);

        }
        for (int j = 1; j < ListaPalabras.size(); j++) {
            int suma = 0;
            a = 0;
            e = 0;
            i = 0;
            o = 0;
            u = 0;

            String palabraIndividual = ListaPalabras.get(j);

            for (int l = 0; l < palabraIndividual.length(); l++) {
                for (int m = 0; m < vocales.length(); m++) {
                    if (palabraIndividual.charAt(l) == 'a') {
                        a = 1;
                    }
                    if (palabraIndividual.charAt(l) == 'e') {
                        e = 1;
                    }
                    if (palabraIndividual.charAt(l) == 'i') {
                        i = 1;
                    }
                    if (palabraIndividual.charAt(l) == 'o') {
                        o = 1;
                    }
                    if (palabraIndividual.charAt(l) == 'u') {
                        u = 1;
                    }

                }

            }
            suma = a + e + i + o + u;

            if (suma == 5) {
                ListaResultados.add("SI");
            } else {
                ListaResultados.add("NO");
            }

        }
        for (int j = 0; j < ListaResultados.size(); j++) {
            System.out.println(ListaResultados.get(j));
        }

    }

}
