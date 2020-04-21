package bloque32;

public class Bloque32 {

    static int aleatorio() {
        int aleatorio = (int) (Math.random() * 100) + 1;

        return aleatorio;

    }

    public static void main(String[] args) {
        for (int x = 0; x < 100; x++) {
            System.out.println(aleatorio());
        }

    }

}
