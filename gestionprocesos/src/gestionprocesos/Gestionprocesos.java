package gestionprocesos;

public class Gestionprocesos {

    public static void main(String[] args) {
        int quantum = (int) (Math.random() * 3) + 1;
        int tiempo = 0;

        int p1[] = new int[5];
        int p2[] = new int[7];
        int tmax = p1.length + p2.length; //Tiempo Maximo
        int tp1 = 0;
        int tp2 = 0;

        for (int x = 0; x < p1.length; x++) {
            p1[x] = (int) (Math.random() * 100) + 1;
            System.out.print(p1[x] + " ");

        }//fin for
        System.out.println("");

        for (int x = 0; x < p2.length; x++) {
            p2[x] = (int) (Math.random() * 100) + 1;
            System.out.print(p2[x] + " ");

        }//fin for

        
        
            for (int y = 0; y < p1.length; y++) {
                tp1++;
            }// Fin for
            
            for(int z = 0; z < p2.length; z++){
                tp2++;
            }
        System.out.println("");
        System.out.println(tp1);
        System.out.println(tp2);
        
    }// fin main

}
