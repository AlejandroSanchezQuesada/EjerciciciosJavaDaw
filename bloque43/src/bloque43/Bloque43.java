package bloque43;

public class Bloque43 {

    public static void main(String[] args) {
        int contador1, contador2;
        contador1 = 0;
        contador2 = 0;
        int a1[] = new int[10];
        int a2[] = new int[10];
        int a3[] = new int[20];

        for (int x = 0; x < 10; x++) {
            int aleatorio1 = (int) (Math.random() * 100 + 1);
            a1[x] = aleatorio1;
            int aleatorio2 = (int) (Math.random() * 100 + 1);
            a2[x] = aleatorio2;

        }//fin for

        int contA = 0;
        int contB = 0;

        for (int x = 0; x < a3.length; x++) {
            for (int y = 0; y < 3; y++) {
                a3[x] = a1[contA];
                x++;
                contA++;
            } // Fin segundo fors
            for (int z = 0; z < 3; z++) {
                a3[x] = a2[contB];
                x++;
                contB++;

            } //Fin tercer for

        }//Fin primer for

        for (int x = 0; x < a1.length; x++) {
            System.out.print(a1[x] + " ");
        }
        System.out.println("");

        for (int x = 0; x < a2.length; x++) {
            System.out.print(a2[x] + " ");
        }
        System.out.println("");

        for (int x = 0; x < a3.length; x++) {
            System.out.print(a3[x] + " ");
        }

    }

}
