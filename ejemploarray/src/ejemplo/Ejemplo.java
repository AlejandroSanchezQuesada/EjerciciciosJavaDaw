package ejemplo;

public class Ejemplo {

    public static void main(String[] args) {

        int v[] = new int[5];

        v[0] = 5;
        v[1] = 7;
        v[2] = 4;
        v[3] = 1;
        v[4] = 6;
        // Imprimir Vector no ordenado
        System.out.println("VECTOR NO ORDENADO");

        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");

        }
        System.out.println("");
        // Ordenacion por Burbuja
        int aux;
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = 0; j < v.length - 1; j++) {
                if (v[j] > v[j + 1]) {
                    aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                } //fin if

            }//fin j

        }//fin for de i
        for(int i = 0; i< v.length;i++){
            System.out.print(v[i]+" ");
        }
    }

}
