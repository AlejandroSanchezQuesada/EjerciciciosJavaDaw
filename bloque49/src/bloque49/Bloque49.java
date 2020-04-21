package bloque49;

public class Bloque49 {

    static int sumarray(int suma, int a1[]) {

        for (int i = 0; i < a1.length; i++) {
            suma = suma + a1[i];
            System.out.print(a1[i] + " ");
        }
        System.out.println("");
        return suma;
    }

    public static void main(String[] args) {
        int suma = 0;

        int a1[] = {23, 4, 56, 21, 8, 5, 32, 12, 1, 2};

        System.out.println(sumarray(suma, a1));

    }

}
