package bloque65;

public class Bloque65 {

    static int sumaArray(int a[][]) {
        int resultado = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                resultado = a[i][j] + resultado;

            }
        }

        return resultado;
    }//fin funcion sumarray

    public static void main(String[] args) {

        int a[][] = new int[7][7];
        int cont = 1;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                a[i][j] = cont;
                cont++;
            }//fin for anidado
        }//fin for

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(a[i][j] + " ");
            }//fin for anidado
        }//fin for
        System.out.println("");
        System.out.println(sumaArray(a));

    }//fin main

}
