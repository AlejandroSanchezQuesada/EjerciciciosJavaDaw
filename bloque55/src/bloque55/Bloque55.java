package bloque55;

public class Bloque55 {

    static void fusionOrdenada(int a1[], int a2[]) {

        int a3[] = new int[a1.length + a2.length];
        int cont1 = 0;
        int cont2 = 0;
        for (int i = 0; i < a3.length; i++) {


            if (cont2 == 5|| (cont1!=5 && (a1[cont1] < a2[cont2]))) {
                a3[i] = a1[cont1];
                cont1++;
            }
            else if (cont1==5 || (cont2!=5 && (a2[cont2] < a1[cont1]))) {
                a3[i] = a2[cont2];
                cont2++;

            }

        }

        for (int i = 0; i < a3.length; i++) {
            
            
            System.out.print(a3[i]+" ");
        }
        
        
    }

    public static void main(String[] args) {

        int a1[] = {2, 3, 6, 7, 8};
        int a2[] = {1, 5, 9, 10, 12};

        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a2[i] + " ");
        }
        System.out.println(" ");
        fusionOrdenada(a1, a2);

    }

}
