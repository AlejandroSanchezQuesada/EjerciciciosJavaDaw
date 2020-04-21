package bloque52;

public class Bloque52 {

    static void ordenaparesimpares(int a[]) {
        int a2[] = new int[a.length];
        //int aux = 0;
        int pos = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {

                a2[pos] = a[i];
                pos++;
            }

        }// fin for
        for (int j = 0; j < a.length; j++) {

            if (a[j] % 2 != 0) {

                a2[pos] = a[j];
                pos++;

            }

        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a2[i] + " ");
        }

    }

    public static void main(String[] args) {
        int a[] = new int[10];

        for (int i = 0; i < 10; i++) {

            a[i] = (int) (Math.random() * 100) + 1;

        }//fin for

        //Mostrar array completo
        for (int i = 0; i < 10; i++) {

            System.out.print(a[i] + " ");
        }//fin for
        System.out.println(" "); //espacio blanco
        ordenaparesimpares(a);

    }

}
