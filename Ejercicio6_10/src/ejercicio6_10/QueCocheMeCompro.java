package ejercicio6_10;

import java.util.LinkedList;
import java.util.Scanner;

public class QueCocheMeCompro {

    public static void main(String[] args) {

        LinkedList<Coche> ListaCoches = new LinkedList<Coche>();
        LinkedList<Coche> ListaCochesV = new LinkedList<Coche>();
        Scanner sc = new Scanner(System.in);
        int ancho, alto, preciomax;

        Coche Skoda = new Coche("Skoda", "Fabia", 250, 450, 400, 0, 2, 25500, "Gasolina", "Manual");
        Coche Fiat = new Coche("Fiat", "Punto", 150, 350, 350, 0, 3, 26000, "Gasolina", "Manual");
        Coche Audi = new Coche("Audi", "TT", 250, 150, 250, 0, 1, 30000, "Diesel", "Manual");
        Coche Dacia = new Coche("Dacia", "Sandero", 250, 200, 225, 0, 4, 15000, "Gasolina", "Manual");
        Coche Ford = new Coche("Ford", "Focus", 250, 210, 220, 0, 3, 21000, "Gasolina", "Automatico");

        ListaCoches.add(Skoda);
        ListaCoches.add(Fiat);
        ListaCoches.add(Audi);
        ListaCoches.add(Dacia);
        ListaCoches.add(Ford);

        System.out.println("Introduzca el ancho del coche");
        ancho = sc.nextInt();
        System.out.println("Introduzc el alto del coche");
        alto = sc.nextInt();
        System.out.println("Introduzca el precio maximo para el coche");
        preciomax = sc.nextInt();

        System.out.println("LISTA CON TODOS LOS COCHES");
        for (int i = 0; i < ListaCoches.size(); i++) {
            System.out.println(ListaCoches.get(i).toString2());
        }

        System.out.println("LISTA COCHES VALIDOS");
        for (int i = 0; i < ListaCoches.size(); i++) {
            if (ListaCoches.get(i).esValido(ancho, alto, preciomax)) {
                System.out.println(ListaCoches.get(i).toString2());
                ListaCochesV.add(ListaCoches.get(i));
            }
        }

        System.out.println("\n LA MEJOR OPCION ES " + Coche.mejorOpcion(ListaCochesV).toString2());

    }

}
