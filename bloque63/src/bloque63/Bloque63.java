package bloque63;

public class Bloque63 {

    public static void main(String[] args) {

        int a[][] = new int[10][10];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                a[0][j] = (int) (Math.random()*10)+1;
            }//fin for anidado
        }//fin for
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                a[i][0] = (int) (Math.random()*10)+1;
            }//fin for anidado
        }//fin for
        
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                a[i][j] = a[0][j] * a[i][0];
            }//fin for anidado
        }//fin for
        

        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println(" ");
        }
        
        
    }//fin main
}
