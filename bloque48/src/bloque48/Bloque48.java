package bloque48;

public class Bloque48 {

    static void ordarray(int a1[]) {
        int aux;
        for (int i = a1.length - 1; i > 0; i--) {
            for (int j = 0; j < a1.length - 1; j++) {
                if (a1[j] > a1[j + 1]) {
                    aux = a1[j];
                    a1[j] = a1[j + 1];
                    a1[j + 1] = aux;

                }//fin if
            }//fin for 2

        }//fin for principal

        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }

    }

    public static void main(String[] args) {

        int a1[] = new int[10];

        for (int i = 0; i < 10; i++) {
            a1[i] = (int) (Math.random() * 100) + 1;
            System.out.print(a1[i] + " ");
        }
        System.out.println(""); //Espacio en blanco
        ordarray(a1);

    }

}
