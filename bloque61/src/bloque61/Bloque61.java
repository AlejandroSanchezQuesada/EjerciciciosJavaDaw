package bloque61;

public class Bloque61 {

    public static void main(String[] args) {
        int a[][] = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                a[i][j] = (int) (Math.random() * 10) + 1;
            }//fin for anidado
        }//fin for

        for (int i = 0; i < 10; i++) {
            int sumatorio = 0;
            for (int j = 0; j < 10; j++) {
                System.out.printf("[%d,%d]: %02d\t", i, j, a[i][j]);
                sumatorio = sumatorio + a[i][j];
            }//fin for anidado
            System.out.println("---> "+sumatorio);
        }//fin for

    }//fin main

}
