package bloque87;

public class Bloque87 {

    public static void main(String[] args) {

        int a[][] = new int[5][5];
        int b[][] = new int[5][5];

        for (int y = 0; y < a.length; y++) {
            for (int x = 0; x < a[y].length; x++) {
                a[y][x] = (int) (Math.random() * 100) + 1;
            }
        }

        for (int y = 0; y < b.length; y++) {
            for (int x = 0; x < b[y].length; x++) {
                b[y][x] = (int) (Math.random() * 100) + 1;
            }
        }

        for (int y = 0; y < a.length; y++) {
            for (int x = 0; x < a[y].length; x++) {
                System.out.print(a[y][x] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

        for (int y = 0; y < b.length; y++) {
            for (int x = 0; x < b[y].length; x++) {
                System.out.print(b[y][x] + " ");
            }
            System.out.println("");
        }

        System.out.println("");
        System.out.println("Los numeros que coinciden son");
        System.out.println("");

        for (int y = 0; y < a.length; y++) {
            for (int x = 0; x < a[y].length; x++) {
                if (a[y][x] == b[y][x]) {
                    System.out.print(a[y][x] + " ");
                }
            }
        }

    }

}
