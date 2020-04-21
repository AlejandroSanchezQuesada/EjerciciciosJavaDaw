package bloque18;

public class Bloque18 {

    public static void main(String[] args) {
       
     int actual,anterior,n;
     actual = 1;
     anterior = 1;
     
     for(n=0;n<100;n++){
     actual = actual+anterior;
     anterior = actual-anterior;
     System.out.print(anterior+" ");
     
     }
        
        
        
    }
    
}
