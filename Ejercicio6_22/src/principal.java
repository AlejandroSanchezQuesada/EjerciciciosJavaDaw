
import java.util.ArrayList;

public class principal {

    public static void main(String[] args) {

        ArrayList<Figura> ListaFiguras = new ArrayList();
        double areaT = 0;

        Cuadrado cuadrado1 = new Cuadrado(0, 0, 5);
        Cuadrado cuadrado2 = new Cuadrado(10, 10, 15);
        Circulo circulo1 = new Circulo(20, 10, 50);
        Circulo circulo2 = new Circulo(40, 20, 150);

        ListaFiguras.add(cuadrado1);
        ListaFiguras.add(cuadrado2);
        ListaFiguras.add(circulo1);
        ListaFiguras.add(circulo2);

        for (int i = 0; i < ListaFiguras.size(); i++) {
            areaT = areaT + ListaFiguras.get(i).Area();
            System.out.println("Posicion" + i + " " + ListaFiguras.get(i).Mostrar() + " Area Total " + areaT);
        }

    }
}
