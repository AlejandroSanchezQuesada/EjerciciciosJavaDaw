package estudiando2;

import java.util.Scanner;

public class Estudiando2 {

    static int Maximo(int n1, int n2, int n3) {
        int maximo=0;
        if (n1 > n2 && n1 > n3) {
            maximo = n1;
        } else if (n2 > n1 && n2 > n3) {
            maximo = n2;
        } else if (n3 > n1 && n3 > n2) {
            maximo = n3;
        }
        return maximo;
    }

    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int n1,n2,n3;
int resultado;
boolean error;
        do{
            try{
                System.out.println("Introduce 3 numeros:");
                n1=sc.nextInt();
                n2=sc.nextInt();
                n3=sc.nextInt();
                error=false;
                resultado=Maximo(n1,n2,n3);
                System.out.println("El máximo es: "+ resultado);
            }catch(Exception e){
                System.out.println("ERROR, INTRODUCE NUMEROS NO LETRAS IMBECIL");
                sc.nextLine();
                error=true;
            }
        }while(error);
    }

}
