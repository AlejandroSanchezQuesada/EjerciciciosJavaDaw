package acepta2reto3;

import java.util.ArrayList;
import java.util.Scanner;

public class Acepta2reto3 {
    
    public static void main(String[] args) {

        ArrayList<String> Codigos = new ArrayList();
        Scanner sc = new Scanner(System.in);
        String _codigos = "";
        int cont = 0;
        boolean prueba1 = true;
        boolean prueba2 = true;
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

            for (int x = 0; x < Codigos.size(); x++) {
                for (int i = 1; i < Codigos.size(); i++) {
                    for (int j = 0; j < 4; j++) {
                        if (x != i) {
                            if (Codigos.get(x).charAt(j) == Codigos.get(i).charAt(j)) {
                                cont++;
                            }
                        }
                    }
                    if (cont == 4) {
                        prueba1 = false;
                    }
                    cont = 0;
                }
            }

            for (int x = 0; x < Codigos.size(); x++) {
                for (int i = 1; i < Codigos.size(); i++) {
                    for (int j = 4; j < 8; j++) {
                        if (x != i) {
                            if (Codigos.get(x).charAt(j) == Codigos.get(i).charAt(j)) {
                                cont++;
                            }
                        }
                    }
                    if (cont == 4) {
                        prueba2 = false;
                    }
                    cont = 0;
                }
            }
            if (prueba1 && prueba2) {
                System.out.println("APROVED");
            } else {
                System.out.println("REJECTED");
            }

            Codigos.removeAll(Codigos);
            prueba1 = true;
            prueba2 = true;
        }

    }

}
