package bloque46;

public class Bloque46 {

    static void desplazaDerecha(int a1[]) {

        int ultimo = a1[a1.length - 1];
        int tamano = a1.length;
        for (int i = tamano - 1; i >= 1; i--) {
            a1[i] = a1[i - 1];

        }
        a1[0] = ultimo;

        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }

    }

    public static void main(String[] args) {

        int a1[] = new int[10];

        for (int x = 0; x < a1.length; x++) {
            a1[x] = x;

            System.out.print(a1[x] + " ");
        }//Fin For
        System.out.println(""); //Espacio en blanco

        desplazaDerecha(a1);

    }//Fin Main

}
