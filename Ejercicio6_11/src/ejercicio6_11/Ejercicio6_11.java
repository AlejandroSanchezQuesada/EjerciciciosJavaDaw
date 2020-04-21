package ejercicio6_11;

public class Ejercicio6_11 {

    public static void main(String[] args) {

        Motor motor = new Motor();
        Rueda rd1, rd2, rd3, rd4;
        rd1 = new Rueda();
        rd2 = new Rueda();
        rd3 = new Rueda();
        rd4 = new Rueda();

        Puerta p1, p2;
        p1 = new Puerta();
        p2 = new Puerta();
        Coche Skoda = new Coche(motor, rd1, rd2, rd3, rd4, p1, p2);

        System.out.println(Skoda.show());

    }

}
