package bloque66;

import java.util.Scanner;

public class Bloque66 {

    public static void main(String[] args) {
        int nfechas, DD, MM;
        Scanner sc = new Scanner(System.in);
        nfechas = sc.nextInt();

        int comprobador[] = new int[nfechas];

        for (int i = 0; i < nfechas; i++) {
            DD = sc.nextInt();
            MM = sc.nextInt();

            if (DD == 25 && MM == 12) {
                comprobador[i] = 1;

            }//fin if
            else {
                comprobador[i] = 0;
            }//fin else

        }//fin for
        
        for (int i = 0; i < nfechas; i++) {
            if (comprobador[i]==1) {
                System.out.println("SI");
            }
            else if(comprobador[i]!=1){
                System.out.println("NO");
            }
            
            
        }
        

    }//fin main

}
