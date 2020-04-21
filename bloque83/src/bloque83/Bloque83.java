package bloque83;

public class Bloque83 {

    static void ordena(String a[]) {
        String aux;
        String cadena;
        String cadenareversa;
        int resultado;

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareTo(a[j]) > 0) {
                    aux = a[i];
                    a[i] = a[j];
                    a[j] = aux;
                }//fin if

            }//for secundario
        }//fin for principal

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static void main(String[] args) {

        String a[] = {"Pedro", "Juan", "Antonio", "Lucas", "Alberto", "Jose"};

        ordena(a);

    }

}
