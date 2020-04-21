package bloque58;

public class Bloque58 {


    public static void main(String[] args) {
        
        int a[][] = new int[10][10];
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a [i][j] = i+j ;
            }//fin for
        }//fin for
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.printf(a[i][j]+" ");
            }
        }
        
    }//fin main
    
}
