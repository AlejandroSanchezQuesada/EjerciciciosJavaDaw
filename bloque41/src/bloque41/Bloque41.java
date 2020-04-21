package bloque41;

public class Bloque41 {

    public static void main(String[] args) {
        int max = 100;
        int min = 0;
        int rango = max - min + 1;
        int ayudante = 0;

        int ya[] = new int[10];

        for (int x = 0; x < ya.length; x++) {
            int aleatorio = (int) (Math.random() * rango) + min;
            ya[x] = aleatorio;
            System.out.print(ya[x] + " ");

        }//Fin del for
        System.out.println(" ");
        int longitud = ya.length - 1;
        for (int i = 0; i < ya.length / 2; i++) {

            System.out.print(ya[i] + " ");
            System.out.print(ya[longitud] + " ");
            longitud--;
        }

    }//fin del for

}//Fin Main
