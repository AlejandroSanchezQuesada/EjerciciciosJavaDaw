package bloque71;

public class Bloque71 {

    public static void main(String[] args) {

        int a[][] = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                a[i][j] = (int) (Math.random() * 10) + 1;

                if (j == 2) {
                    a[i][j] = a[i][0] + a[i][1];
                }

            }//fin for anidado

        }//fin for

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println(" ");
        }

    }

}
