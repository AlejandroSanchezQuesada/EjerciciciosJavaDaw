package bloque51;

import java.util.Scanner;

public class Bloque51 {

    static void elimina(int a[], int pos){
    pos = pos-1; //Para poder trabajar correctamente con posiciones de array
    
        for (int x = pos; x < a.length-1; x++) {
            
            a[x] = a[x+1];
        }
    a[a.length-1] = 0;
        System.out.println(""); //Espacio en blanco
        for (int y = 0; y < 10; y++) {
            System.out.print(a[y] + " ");
        }
    
    }
    
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = new int[10];

        for (int x = 0; x < 10; x++) {

            a[x] = (int) (Math.random() * 100) + 1;
            System.out.print(a[x] + " ");
        }//fin for
        
        try {
            System.out.println("");//espacio blanco
            System.out.println("Introduce posición a eliminar de Array VALORES 1 - 10");
            int posicion = sc.nextInt();
            elimina(a,posicion);
            
            
            
            
        } catch (Exception e) {
            
            System.out.println("HA HABIDO UN ERROR");
            
        }
        
        

    }

}
