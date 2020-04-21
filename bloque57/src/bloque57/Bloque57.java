package bloque57;

public class Bloque57 {

    static void union(int a1[], int a2[]) {
        
        int cont = 0;
        int contarray2 = 0;
        int comparador = 0;
        int comparador2 = 0;
        
        
        int a3[] = new int[a1.length + a2.length];
        int a4[] = new int [a3.length];

        for (int i = 0; i < a1.length; i++) {

            a3[i] = a1[i];
            cont++;
        }//fin for de añadir el array 1 al 3
        for (int i = cont; i < a3.length; i++) {

            a3[i] = a2[contarray2];
            contarray2++;

        }//fin for de unir array 2 al 3
        
        
        for (int i = 0; i < a3.length; i++) {
            
            for (int j = 0; j < a3.length; j++) {
                
                if(a3[i]==a3[j]){}
                
                //Me he quedado aquí no se muy bien como indicarle 
                // me falta tiempo por el tiempo de entrega
                
                
            }
            
            
        }
        
        
        
        
        
       
        
        
        
    }//fin funcion union

    public static void main(String[] args) {

        int a1[] = {2, 56, 3, 45, 8, 21, 10, 11, 12, 89};
        int a2[] = {3, 4, 1, 67, 1, 83, 5, 0, 18, 7};
        //Inicialización arrays a mano

        for (int i = 0; i < 10; i++) {
            System.out.print(a1[i] + " ");
        }//fin for
        System.out.println(" ");//espacio blanco
        for (int i = 0; i < 10; i++) {
            System.out.print(a2[i] + " ");
        }//fin for
        System.out.println(" ");//espacio blanco

        union(a1, a2);

    }//fin main

}
