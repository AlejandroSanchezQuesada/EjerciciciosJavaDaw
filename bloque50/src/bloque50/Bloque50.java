package bloque50;

public class Bloque50 {

    static int mcd(int a1[]) {
        int divisor = 1;
        int mayor = 1;
        for (int i = 0; i < a1.length; i++) {

            if (a1[i] >= mayor) {
                mayor = a1[i];

            }//fin if

        }//fin for


        do {
            if (a1[0] % mayor == 0 && a1[1] % mayor == 0 && a1[2] % mayor == 0 && a1[3] % mayor == 0) {
                divisor = mayor;
                break;
            }
            mayor--;
        }while(mayor >=1);

        return divisor;
    }

    public static void main(String[] args) {

        int a1[] = {5, 26, 15, 5};

        System.out.println(mcd(a1));
    }

}
