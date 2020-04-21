package ejercicio6_9;

import java.util.ArrayList;

public class Ejercicio6_9 {

    public static void main(String[] args) {

        Cancion c1 = new Cancion("Corazon Latino", "Ernesto Sevilla");
        Cancion c2 = new Cancion("Se me va la vida", "Maria Valverde");
        Cancion c3 = new Cancion("La carretera", "Sergio Dalma");

        ArrayList<Cancion> canciones;

        canciones = new ArrayList();

        canciones.add(c1);
        canciones.add(c2);
        canciones.add(c3);

        for (int i = 0; i < canciones.size(); i++) {
            System.out.println(canciones.get(i).toString2() + "\n");
        }

    }

}
