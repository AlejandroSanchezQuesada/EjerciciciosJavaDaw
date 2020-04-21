package bloque62;

public class Bloque62 {

    static void trans(int a[][]) {

        int a2[][] = new int[5][9];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                a2[i][j] = a[j][i];
            }
        }
        System.out.println(" ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(a2[i][j] + " ");
            }
            System.out.println(" ");
        }

    }//fin funcion trans

    public static void main(String[] args) {

        int a[][] = new int[9][5];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = (int) (Math.random() * 10) + 1;
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println(" ");
        }

        trans(a);

    }

}
