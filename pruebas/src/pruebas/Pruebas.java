package pruebas;

public class Pruebas {

    public static void main(String[] args) {
        
       int tablero[][] = new int[3][3];
       int cuentamovimientos = 0;
    //Constructor
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                tablero[x][y] = 0;
                if (tablero[x][y]==0) {
                    cuentamovimientos++;
                }
            }
        }
        
        System.out.println(cuentamovimientos);
        
        
        
        
    }
        
      
    
    
    
    }
    

