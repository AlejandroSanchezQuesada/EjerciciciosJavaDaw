package principal;

import java.util.ArrayList;

public class mainpruebas {

    public static void main(String[] args) {

        ArrayList<Electrodomestico> Lista = new ArrayList();
        Electrodomestico defecto = new Electrodomestico();
        Lavadora lava1 = new Lavadora(400, "blanco", 'A', 70, 8);
        Lavadora lava2 = new Lavadora(3600, "gris", 'B', 150, 35);
        Television tv1 = new Television();
        Television tv2 = new Television(1200, "negro", 'A', 30, 42, true);
        Television tv3 = new Television(800, "blanco", 'B', 35, 42, true);
        Television tv4 = new Television(1999, "gris", 'A', 30, 70, false);

        Lista.add(defecto);
        Lista.add(lava1);
        Lista.add(lava2);
        Lista.add(tv1);
        Lista.add(tv2);
        Lista.add(tv3);
        Lista.add(tv4);

        for (int i = 0; i < Lista.size(); i++) {
            System.out.println(Lista.get(i).toString());
        }

        System.out.println("------------------------------");
        System.out.println("LISTA PRECIOS POR CLASE");
        float precio = 0;
        float total = 0;
        precio = 0;
        for (int i = 0; i < Lista.size(); i++) {

            if (Lista.get(i) instanceof Lavadora) {
                precio = precio + Lista.get(i).getPrecio();
            }

        }
        System.out.println("Precios Lavadora total = " + precio);
        total = total + precio;
        precio = 0;
        for (int i = 0; i < Lista.size(); i++) {

            if (Lista.get(i) instanceof Television) {
                precio = precio + Lista.get(i).getPrecio();

            }

        }
        System.out.println("Precios Television total = " + precio);
        total = total + precio;

        System.out.println("Precios Total = " + total);

    }

}
