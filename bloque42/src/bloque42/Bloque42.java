package bloque42;

public class Bloque42 {

    static void empiezarray(int a1[], int a2[]) {

        for (int x = 0; x < a1.length; x++) {
            int aleatorio = (int) (Math.random() * 100) + 1;
            a1[x] = aleatorio;

        }//Fin del for
        for (int x = 0; x < a2.length; x++) {
            int aleatorio = (int) (Math.random() * 100) + 1;
            a2[x] = aleatorio;

        }//Fin del For

    }//Fin Empieza Array

    static void mezclaarray(int a3[], int a1[], int a2[]) {
        int contador = 0;
        for (int x = 0; x < a1.length; x++) {
            a3[contador] = a1[x];
            contador++;
            a3[contador] = a2[x];
            contador++;

        }//fin for

    }
    
    static void mostrararrays(int a1[], int a2[],int a3[]){
    for(int x=0;x<a1.length;x++){
        System.out.print(a1[x]+" ");
    }
        System.out.println("");
    for(int y=0;y<a2.length;y++){
        System.out.print(a2[y]+" ");
    }
        System.out.println("");
    for(int c=0;c<a3.length;c++){
        System.out.print(a3[c]+" ");
    }
    
    
    }

    public static void main(String[] args) {

        int[] a1 = new int[10], a2 = new int[10];
        int[] a3 = new int[20];

        empiezarray(a1, a2);
        mezclaarray(a3, a1, a2);
        mostrararrays(a1, a2, a3);

    }//Fin Main

}
