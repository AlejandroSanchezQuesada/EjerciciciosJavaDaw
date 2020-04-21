package examen1;

public class Examen1 {

    public static void main(String[] args) {

        Punto p1 = new Punto(5, 5);
        Punto p2 = new Punto(15, 20);

        p1.desplaza(0, 5);
        p2.desplaza(3, 0);

        Rectangulo r1 = new Rectangulo(p1.getCordenadaY(), p1.getCordenadaX(), p2.getCordenadaY(), p2.getCordenadaX());

        System.out.println(r1.Area());
        r1.Dibuja();
    }

}
