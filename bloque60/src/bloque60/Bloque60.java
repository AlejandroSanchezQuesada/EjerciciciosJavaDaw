package bloque60;

public class Bloque60 {

    public static void main(String[] args) {

        int a[][] = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {

                    if (i == j) {
                        a[i][j] = 10;

                    } else if (i != j) {
                        a[i][j] = 0;

                    }

                }//fin for3
                
            }//fin for2
            
        }//fin for

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("[%d,%d]: %02d\t", i, j, a[i][j]);
                
            }
            System.out.println(" ");
        }

    }//fin main

}
