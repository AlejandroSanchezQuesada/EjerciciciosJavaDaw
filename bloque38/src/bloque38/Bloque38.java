package bloque38;

import java.util.Scanner;

public class Bloque38 {

    static int LEER_NUMERO() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        return N;
    }
    static void PRIMOS_ANTERIORES(int N){
    
    for(int x=1;N>=x;N--){
        if(N%2==0 || N%3==0 || N%5==0 || N%7==0 || N%11==0){}
        else{System.out.println(N);}
        
        
    }
        

    }
    

    public static void main(String[] ARGUMENTOS) {
        int N;
        System.out.println("Introduce numero y te digo sus primos anteriores");
        N = LEER_NUMERO();
        
        PRIMOS_ANTERIORES(N);

    }

}
