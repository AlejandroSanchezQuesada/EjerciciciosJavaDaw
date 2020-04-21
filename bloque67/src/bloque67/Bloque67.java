package bloque67;

import java.util.Scanner;

public class Bloque67 {

    public static void main(String[] args) {

        boolean cierra = false;
        while(cierra == false){
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        
            if (e==0) {
                cierra = true;
            }
        
        
        int c = sc.nextInt();
        int comida;
        int calorias = 0;

        for (int i = 0; i < c; i++) {
            comida = sc.nextInt();
            calorias = calorias + comida;
        }

        int nveces;

        nveces = calorias / e;
        if (nveces != 0) {
            nveces++;
        }
        System.out.println(nveces);
        }
    }//fin main

}
