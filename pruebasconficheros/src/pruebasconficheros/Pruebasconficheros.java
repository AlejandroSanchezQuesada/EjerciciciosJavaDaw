package pruebasconficheros;

import java.util.Scanner;

public class Pruebasconficheros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int operaciones = sc.nextInt();
        for (int i = 0; i < operaciones; i++) {
            int op1 = sc.nextInt();
            int op2 = sc.nextInt();
            System.out.println(op1 + op2);

        }

    }
}
