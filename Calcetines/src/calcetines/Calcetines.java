package calcetines;

import java.util.Scanner;

public class Calcetines {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char calcet;
        int contN, contG, cantidadcalcetines;
        do {
            contN = 0;
            contG = 0;
            cantidadcalcetines = 0;
            do {
                calcet = Character.toLowerCase(sc.next().charAt(0));
                if (calcet == 'n') {
                    contN++;
                    cantidadcalcetines++;
                } else if (calcet == 'g') {
                    contG++;
                    cantidadcalcetines++;
                }
            } while (calcet != '.');

            if (contG == 0 && contN == 0) {

            } else if (contG % 2 == 0 && contN % 2 == 0) {
                System.out.println("EMPAREJADOS");
            } else if (contG % 2 == 0 && contN %2 !=0) {
                System.out.println("NEGRO SOLITARIO");
            } else if (contN % 2 == 0 && contG %2 !=0) {
                System.out.println("GRIS SOLITARIO");
            } else if(contG % 2 != 0 && contN %2 !=0){
                System.out.println("PAREJA MIXTA");
            }

        } while (cantidadcalcetines != 0);

    }
}
