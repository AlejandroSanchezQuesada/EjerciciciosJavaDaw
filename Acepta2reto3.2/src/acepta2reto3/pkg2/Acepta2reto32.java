package acepta2reto3.pkg2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Acepta2reto32 {

    public static void main(String[] args) {

        Set<String> Coleccion1 = new TreeSet<>();
        Set<String> Coleccion2 = new TreeSet<>();
        ArrayList<String> CantidadCodigos1 = new ArrayList();
        ArrayList<String> CantidadCodigos2 = new ArrayList();
        ArrayList<String> Codigos = new ArrayList();
        Scanner sc = new Scanner(System.in);
        String _codigos = "";
        int n_pruebas;
        n_pruebas = sc.nextInt();
        for (int y = 0; y < n_pruebas; y++) {
            do {
                _codigos = sc.next();
                _codigos = _codigos.toUpperCase();
                if (!_codigos.equals("00000000")) {
                    Codigos.add(_codigos);
                }
            } while (!_codigos.equals("00000000"));

            for (int i = 0; i < Codigos.size(); i++) {
                    String bloqueA  = Codigos.get(i).substring(0,3);
                    String bloqueB  = Codigos.get(i).substring(4,7);

                CantidadCodigos1.add(bloqueA);
                CantidadCodigos2.add(bloqueB);
                Coleccion1.add(bloqueA);
                Coleccion2.add(bloqueB);
            }
            if (CantidadCodigos1.size() == Coleccion1.size() && CantidadCodigos2.size() == Coleccion2.size()) {
                System.out.println("APROVED");
            } else {
                System.out.println("REJECTED");

            }
            Codigos.removeAll(Codigos);
            CantidadCodigos1.removeAll(CantidadCodigos1);
            CantidadCodigos2.removeAll(CantidadCodigos2);
            Coleccion1.removeAll(Coleccion1);
            Coleccion2.removeAll(Coleccion2);

        }

    }

}
