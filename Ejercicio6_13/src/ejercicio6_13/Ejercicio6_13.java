package ejercicio6_13;

import java.util.ArrayList;

public class Ejercicio6_13 {

    public static void main(String[] args) {

        ArrayList<Libro> Libros;
        Libros = new ArrayList();

        Libro l1 = new Libro("Patria", "Fernando Aramburu", "978-84-9066-319-6", 210);
        Libro l2 = new Libro("El Monarca de las sombras", "Jabier Cercas", "978-84-397-3257-0", 314);
        Libro l3 = new Libro("La magia de ser Sofia", "Elisabet Benavent", "978-84-9129-110-7", 456);

        Libros.add(l1);
        Libros.add(l2);
        Libros.add(l3);

        for (int i = 0; i < Libros.size(); i++) {
            System.out.println(Libros.get(i).toString2());
        }

    }

}
