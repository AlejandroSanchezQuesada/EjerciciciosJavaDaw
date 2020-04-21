
import java.util.ArrayList;

public class principal {

    public static void main(String[] args) {

        ArrayList<empleado> Lista = new ArrayList();

        repartidor r = new repartidor("Fernando Trujillo", 26, 900, "zona3");
        comercial c = new comercial("Juan Bastida", 37, 1000, 300);

        Lista.add(r);
        Lista.add(c);

        for (int i = 0; i < Lista.size(); i++) {
            if (Lista.get(i).TienePlus()) {
                System.out.println(Lista.get(i).nombre + " es un " + Lista.get(i).getClass().getName() + " y SI se le ha aplicado el PLUS");
            } else {
                System.out.println(Lista.get(i).nombre + " es un " + Lista.get(i).getClass().getName() + " y NO se le ha aplicado el PLUS");

            }
        }

        System.out.println("");

        for (int i = 0; i < Lista.size(); i++) {
            System.out.println(Lista.get(i).toString());
        }

    }
}
